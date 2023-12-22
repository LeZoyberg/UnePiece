import { Component } from '@angular/core';
import { PirateService } from '../pirate.service';
import { Joueur, Membre, Partie, Pirate } from '../model';
import { PartieService } from '../partie.service';
import { AuthService } from '../auth.service';
import { MembreService } from '../membre.service';

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
    this.partieService.findByIdJoueur(this.joueur.id).subscribe(resp => {
      
      this.partie.id = resp.id;
      this.partie.duree = resp.duree; 
      console.log("ICIIIIIIIIIIIIIIIIIIII3");
      this.membre.partie=resp;
      this.membre.pv=capitaine.pv;
      this.membre.pirate=capitaine;
      this.membre.power=capitaine.power;
      this.partie.tresor = capitaine.prime;
      this.membreService.create(this.membre).subscribe(resp =>{
        this.partie.membres?.push(resp)
        console.log('this.partie.membres :>> ', this.partie.membres);
        console.log(resp)
      });
      this.partieService.update(this.partie).subscribe();
      console.log('capitaine :>> ', capitaine);
      console.log('capitaine :>> ', this.membre);
     
      console.log('resp :>> ', resp);
      console.log('this.partie :>> ', this.partie);
    });

  }
}
