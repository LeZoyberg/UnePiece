import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Joueur, Partie } from '../model';
import { PartieService } from '../partie.service';
import { StartComponent } from '../start/start.component';

@Component({
  selector: 'ile',
  templateUrl: './ile.component.html',
  styleUrls: ['./ile.component.css'],
})
export class IleComponent {
  joueur: Joueur = new Joueur();
  partie: Partie = this.partieService.getPartie();

  constructor(
    private authService: AuthService,
    private partieService: PartieService
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    console.log('this.joueur :>> ', this.joueur);
    console.log('this.partie :>> ', this.partie);
  }
}
