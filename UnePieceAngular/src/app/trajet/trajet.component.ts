import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PartieService } from '../partie.service';
import { Ile, Joueur, Partie } from '../model';
import { AuthService } from '../auth.service';
import { IleService } from '../ile.service';
import { ActionService } from '../action.service';

@Component({
  selector: 'app-trajet',
  templateUrl: './trajet.component.html',
  styleUrls: ['./trajet.component.css'],
})
export class TrajetComponent {
  //tpsTrajetRestant: number;
  joueur!: Joueur;
  partie!: Partie;
  //ile?: Ile;

  constructor(
    private router: Router,
    private partieService: PartieService,
    //private ileService: IleService,
    private authService: AuthService,
    private actionService: ActionService,
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie() as Partie;
    //this.tpsTrajetRestant = this.partieService.getPartie()?.ile?.attente as number;

    /*
      this.joueur = this.authService.getUtilisateur() as Joueur;
      if(this.joueur != undefined){
        this.partieService.findByIdJoueur(this.joueur.id).subscribe(resp => {
          console.log("ile id : " + resp.ile?.id)
          this.ile = resp.ile?.id;
        });
      }
      */
  }

  suite() {
    if (this.partie.joursRestants! > 1) {
      this.partie.joursRestants!--;
      this.partie.duree!++;
      this.partieService.update(this.partie).subscribe(() => {
        this.partieService.savePartieInStorage(this.partie);
      });
    } else {
      this.partie.joursRestants = this.partie.ile?.attente;
      this.partie.duree!++;
      this.partieService.update(this.partie).subscribe(() => {
        this.partieService.savePartieInStorage(this.partie);
        this.router.navigate(['/ile']);
      });
    }
  }

  /*
  Suite(){
    if(this.tpsTrajetRestant > 1){
      this.tpsTrajetRestant--;            
      (this.partie.ile!.attente as number) = this.tpsTrajetRestant;

      this.partieService.update(this.partie).subscribe(() => {
        this.partieService.savePartieInStorage(this.partie);
        this.router.navigate(['/trajet/']);
      });      
    }
    else{
      //console.log("--- Suite else before findById : " + this.partie.ile!.attente);
      this.ileService.findById(this.partie.ile!.id).subscribe(resp => {
        //console.log("--- Suite else in findById 1 : " + resp.attente);
        this.partie.ile!.attente = resp.attente;
        //console.log("--- Suite else after findById : " + this.partie.ile!.attente);
        this.partieService.savePartieInStorage(this.partie);
        this.router.navigate(['/ile/']);
      });      
    }
  }
  */
}
