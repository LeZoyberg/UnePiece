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
  ile:Ile = new Ile();
  idIle!: number;

  constructor(
    private authService: AuthService,
    private partieService: PartieService,
    private ileService: IleService
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie();
    this.ile = this.ileService.determineIle();
    console.log('this.joueur :>> ', this.joueur);
    console.log('this.partie :>> ', this.partie);
  }
  showIle() {
    return `Nom : ${this.ile.nom} / Taverne : ${this.ile.taverne} / Chantier : ${this.ile.chantier} / Auberge :  ${this.ile.auberge} / Attente : ${this.ile.attente} / Ordre : ${this.ile.ordre} / Mer : ${this.ile.mer}`
  }
}
