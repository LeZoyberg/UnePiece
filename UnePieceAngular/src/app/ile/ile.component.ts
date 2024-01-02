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
    this.partieService.findByIdJoueur(this.joueur.id).subscribe(resp => {
      this.ile = this.ileService.determineIle();
      console.log('this.ile :>> ', this.ile);
      this.partie = resp;
      this.partie.dateDebut = this.partieService.getPartie().dateDebut;
      // manque calcul durée partie (Date.now - dateDebut)
      this.partie.termine = false;
      this.partie.tresor = this.partieService.getPartie().tresor;
      this.partie.ile = this.ile;
      this.partie.joueur = this.joueur;
      this.partie.membres = this.partieService.getPartie().membres;
      this.partieService.setPartie(this.partie);
      this.partieService.update(this.partie).subscribe();
      console.log('this.joueur :>> ', this.joueur);
      console.log('this.partie :>> ', this.partie);
    });
  }
  showIle() {
    return `Nom : ${this.ile.nom} / Taverne : ${this.ile.taverne} / Chantier : ${this.ile.chantier} / Auberge :  ${this.ile.auberge} / Attente : ${this.ile.attente} / Ordre : ${this.ile.ordre} / Mer : ${this.ile.mer}`
  }
}
