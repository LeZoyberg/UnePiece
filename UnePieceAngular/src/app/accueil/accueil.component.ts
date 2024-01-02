import { Component } from '@angular/core';
import { Joueur, Partie } from '../model';
import { PartieService } from '../partie.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
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
    private authService: AuthService
  ) {}

  /* WIP : comment checker si this.partieService.findByIdJoueur(this.authService.getUtilisateur()?.id) 
  renvoie quelque chose (i.e. qu'une partie existe pour ce joueur dans la bdd) sans que ça crash ? */
  continueGame() {
    this.partieService
      .findByIdJoueur(this.authService.getUtilisateur()?.id)
      ?.subscribe((resp) => {
        if (!!resp && resp.termine == false) {
          console.log('[continueGame() in accueil.component.ts] Une partie en cours a été trouvée pour ce joueur');
          this.partie = resp;
          // TODO : set les autres attributs de la partie (ile, membres, actions, ...)
          this.router.navigate(['/ile']);
          console.log('[continueGame() in accueil.component.ts] this.partie :>> ', this.partie);
        } else this.newGame();
      });
  }

  newGame() {
    
    this.partie = new Partie();
    this.partie.termine = false;
    this.partie!.joueur = this.authService.getUtilisateur();
    this.partie.duree = 0;
    this.partie.dateDebut = new Date(Date.now()).toISOString().substr(0, 10);
    this.partieService.create(this.partie).subscribe((resp) => {
      this.router.navigate(['/start']);
      console.log('[newGame() in accueil.component.ts] this.partie :>> ', this.partie);
    });
  }
}
