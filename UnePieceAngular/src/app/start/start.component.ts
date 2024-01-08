import { Component } from '@angular/core';
import { PirateService } from '../pirate.service';
import { Joueur, Membre, Partie, Pirate } from '../model';
import { PartieService } from '../partie.service';
import { AuthService } from '../auth.service';
import { MembreService } from '../membre.service';
import { Router } from '@angular/router';
import { IleService } from '../ile.service';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css'],
})
export class StartComponent {
  capitaines: Pirate[] = [];
  joueur: Joueur = {};
  partie: Partie = new Partie();
  membre: Membre = new Membre();

  constructor(
    private pirateService: PirateService,
    private partieService: PartieService,
    private authService: AuthService,
    private membreService: MembreService,
    private ileService: IleService,
    private router: Router
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie(this.joueur);
    if(this.partie) {
      this.load();
    } else {
      this.partieService.getPartieFromDb(this.joueur).subscribe(resp => {
        this.partie = resp;
        this.load();
      })
    }
  }

  load() {
    console.log('this.partie start :>> ', this.partie);
    this.listCapitaines();
  }

  listCapitaines() {
    // TODO : plutôt faire une requête HTTP dédiée qui ramène directement les bons pirates
    this.pirateService.findAll().subscribe((resp) => {
      this.capitaines = resp;
      this.capitaines = this.capitaines.filter(
        (pirate) => pirate.capitaine == true
      );
      // Mélanger aléatoirement la liste des capitaines
      this.capitaines.sort(() => Math.random() - 0.5);
      // Sélectionner les trois premiers pirates aléatoires
      this.capitaines = this.capitaines.slice(0, 3);
    });
  }

  chooseCapitaine(capitaine: Pirate) {
    this.membre.partie = this.partie;
    this.membre.pv = capitaine.pv;
    this.membre.pirate = capitaine;
    this.membre.power = capitaine.power;
    this.partie.tresor = capitaine.prime;
    /*
    console.log('this.membre before create :>> ', this.membre);
    this.membreService.create(this.membre).subscribe(resp =>{
      this.partie.membres?.push(resp);
      console.log('this.partie before update :>> ', this.partie);

      this.partieService.update(this.partie).subscribe(() => {
        console.log('this.partie in update 1 :>> ', this.partie);
        this.partieService.savePartieInStorage(this.partie);
        console.log('this.partie in update 2 :>> ', this.partie);
        this.router.navigate(['/ile']);
      });

      console.log('this.partie after update :>> ', this.partie);
    });
    */

    this.partieService.update(this.partie).subscribe(() => {
      this.membreService.create(this.membre).subscribe((resp) => {
        this.partie.membres?.push(resp);
        this.partieService.getForceTotale();
        this.partieService.savePartieInStorage(this.partie);
        this.partieService.redirect(this.partie);
      });
    });
  }
}
