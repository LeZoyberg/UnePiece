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
    this.partie = this.partieService.getPartie(this.joueur);
    if(this.partie) {
      this.load();
    } else {
      this.partieService.getPartieFromDb(this.joueur).subscribe(resp => {
        this.partie = resp;
        this.load();
      });
    }
  }
  load() {
    console.log('this.partie trajet :>> ', this.partie);
  }
  suite() {

    if (this.partie.joursRestants! > 1) {
      this.partie.joursRestants!--;
      this.partie.duree!++;
      this.partieService.update(this.partie).subscribe();
    } else {
      this.partie.joursRestants = this.partie.ile?.attente;
      this.partie.duree!++;
      this.partieService.update(this.partie).subscribe(() => {
        this.partieService.redirect(this.partie);
      });
    }
  }
}
