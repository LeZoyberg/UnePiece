import { Component } from '@angular/core';
import { Joueur, Partie } from '../model';
import { PartieService } from '../partie.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { IleService } from '../ile.service';
@Component({
  selector: 'accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css'],
})
export class AccueilComponent {
  partie?: Partie;

  constructor(
    private partieService: PartieService,
    private router: Router,
    private authService: AuthService,
    private ileService: IleService,
  ) {
    this.partie = this.partieService.getPartie();
  }

  continueGame() {
    this.partieService
      .findByIdJoueurWithMembres(this.authService.getUtilisateur()?.id)
      ?.subscribe((resp) => {
        if (!!resp && resp.termine == false) {
          console.log('[continueGame() in accueil.component.ts] Une partie en cours a été trouvée pour ce joueur');
          this.partie = resp;
          this.partie.joueur = this.authService.getUtilisateur();
          console.log('[continueGame() in accueil.component.ts] this.partie :>> ', this.partie);
          this.router.navigate(['/ile']);
        } else this.newGame();
      });
  }

  newGame() {
    this.partie = new Partie();
    this.partie.termine = false;
    this.partie.joueur = this.authService.getUtilisateur();
    this.partie.duree = 0;
    this.partie.ile = this.ileService.determineIle(this.partie);
    this.partie.dateDebut = new Date(Date.now()).toISOString().substr(0, 10);
    this.partieService.create(this.partie).subscribe((resp) => {
      this.partie = resp;
      console.log('[newGame() in accueil.component.ts] this.partie :>> ', this.partie);
      this.router.navigate(['/start']);
    });
  }
}
