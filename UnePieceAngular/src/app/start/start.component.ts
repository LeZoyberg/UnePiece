import { Component } from '@angular/core';
import { PirateService } from '../pirate.service';
import { Joueur, Membre, Partie, Pirate } from '../model';
import { PartieService } from '../partie.service';
import { AuthService } from '../auth.service';
import { MembreService } from '../membre.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css'],
})
export class StartComponent {
  capitaines: Pirate[] = [];
  joueur: Joueur = {};
  partie: Partie = new Partie();
  membre: Membre= new Membre();
  constructor(
    private pirateService: PirateService,
    private partieService: PartieService,
    private authService: AuthService,
    private membreService: MembreService,
    private router : Router
  ) {
    this.listCapitaines();
    this.joueur = this.authService.getUtilisateur() as Joueur;
    //console.log('this.partie CONTROLLER :>> ', this.partie);
  }

  listCapitaines() {
    this.pirateService.findAll().subscribe((resp) => {
      this.capitaines = resp;
      this.capitaines = this.capitaines.filter(
        (pirate) => pirate.capitaine == true
      );
    });
  }
  chooseCapitaine(capitaine:Pirate) {
    this.partie.joueur = this.authService.getUtilisateur();
    this.partieService.findByIdJoueur(this.joueur.id).subscribe(resp => {
      
      this.partie.id = resp.id;
      this.partie.duree = resp.duree; 
      this.partie.dateDebut = resp.dateDebut;
      this.partie.termine = resp.termine;
      this.partie.tresor = capitaine.prime;

      this.membre.partie=resp;
      this.membre.pv=capitaine.pv;
      this.membre.pirate=capitaine;
      this.membre.power=capitaine.power;
      this.membreService.create(this.membre).subscribe(resp =>{
        this.partie.membres?.push(resp);
      });

      this.partieService.update(this.partie).subscribe();
      console.log('this.partie :>> ', this.partie);
      this.partieService.setPartie(this.partie);
      this.router.navigate(['/ile']);
    });


  }
}
