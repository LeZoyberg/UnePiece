import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Ile, Joueur, Partie } from '../model';
import { PartieService } from '../partie.service';
import { StartComponent } from '../start/start.component';
import { IleService } from '../ile.service';

@Component({
  selector: 'ile',
  templateUrl: './ile.component.html',
  styleUrls: ['./ile.component.css'],
})
export class IleComponent {
  joueur: Joueur = this.authService.getUtilisateur() as Joueur;
  partie: Partie = this.partieService.getPartie();
  idIle!: number;

  constructor(
    private authService: AuthService,
    private partieService: PartieService,
    private ileService: IleService
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie();
    this.determineIle();
    console.log('this.joueur :>> ', this.joueur);
    console.log('this.partie :>> ', this.partie);
  }

  determineIle() {
    // si pas d'ile associée à la partie, set l'ile sur l'ile de départ
    console.log("determineIle");
    if (this.partie.ile == undefined) {
      this.idIle = 1;
    } else {
      this.idIle = this.partie.ile.id as number;
    }
    this.ileService.findById(this.idIle).subscribe((resp) => {
      this.partie.ile = resp;
    });
    this.partieService.setPartie(this.partie);
  }
}
