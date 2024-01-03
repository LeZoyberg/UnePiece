import { Component } from '@angular/core';
import { Ile, Joueur, Partie } from '../model';
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
  joueur?: Joueur;
  partie?: Partie;
  parties?: Partie[];
  constructor(
    private partieService: PartieService,
    private router: Router,
    private authService: AuthService,
    private ileService: IleService
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie();
    if (this.partie) {
      this.partie.joueur = this.joueur;
    }
    this.partieService.findAll().subscribe((resp) => {
      this.parties = resp;
      console.log('this.parties :>> ', this.parties);
    });
  }

  continueGame() {
    //console.log(this.joueur?.id);
    this.partieService
      .findByIdJoueurWithMembres(this.joueur?.id)
      ?.subscribe((resp) => {
        console.log(resp);
        if (resp && resp.termine == false) {
          console.log(
            '[continueGame() in accueil.component.ts] Une partie en cours a été trouvée pour ce joueur'
          );
          this.partie = resp;
          this.partie.forceTotale = 0;

          this.partie.joueur = this.joueur;
          this.partieService.savePartieInStorage(this.partie);
          console.log(
            '[continueGame() in accueil.component.ts] Partie en cours = this.partie :>> ',
            this.partie
          );
          this.router.navigate(['/ile']);
        } else this.newGame();
      });
  }

  newGame() {
    this.partie = new Partie();
    this.partie.termine = false;
    this.partie.joueur = this.joueur;
    this.partie.duree = 0;
    this.partie.dateDebut = new Date(Date.now()).toISOString().substr(0, 10);
    this.partie.forceTotale = 0;

    this.ileService.findById(1).subscribe((resp) => {
      if (this.partie) {
        this.partie.ile = resp;
        this.partieService.create(this.partie).subscribe((resp) => {
          console.log(
            '[newGame() in accueil.component.ts] this.partie :>> ',
            this.partie
          );
          if (this.partie) {
            this.partie.id = resp.id;
            this.partieService.savePartieInStorage(this.partie);
          }
          this.router.navigate(['/start']);
        });
      }
    });
  }
}
