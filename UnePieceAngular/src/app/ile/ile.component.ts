import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Ile, Joueur, Membre, Partie } from '../model';
import { PartieService } from '../partie.service';
import { StartComponent } from '../start/start.component';
import { IleService } from '../ile.service';
import { MembreService } from '../membre.service';

@Component({
  selector: 'ile',
  templateUrl: './ile.component.html',
  styleUrls: ['./ile.component.css'],
})
export class IleComponent {
  joueur: Joueur = this.authService.getUtilisateur() as Joueur;
  //partie: Partie = this.partieService.getPartie();
  //ile:Ile = new Ile();
  ile?:Ile;
  idIle!: number;
  joursRestants!:number;

  constructor(
    private authService: AuthService,
    private partieService: PartieService,
    private ileService: IleService,
    private membreService: MembreService,
  ) {
    /*this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partieService.findByIdJoueur(this.joueur.id).subscribe(resp => {
      this.ile = this.ileService.determineIle();
      console.log('this.ile :>> ', this.ile);
      this.partie = resp;
      this.partie.dateDebut = this.partieService.getPartie().dateDebut;
      // manque calcul durée partie (Date.now - dateDebut)
      this.partie.termine = false;
      this.partie.tresor = this.partieService.getPartie().tresor;
      this.partie.ile = this.ile;
      this.joursRestants=this.ile.attente as number;
      this.partie.joueur = this.joueur;
      this.partie.membres = this.partieService.getPartie().membres;
      this.partieService.setPartie(this.partie);
      this.partieService.update(this.partie).subscribe();
      console.log('this.joueur :>> ', this.joueur);
      console.log('this.partie :>> ', this.partie);
    });*/

    this.joueur = this.authService.getUtilisateur() as Joueur;

    this.partieService.findByIdJoueur(this.joueur.id).subscribe(resp => {
      if(resp.ile?.id){
        console.log('resp.ile?.id :>> ', resp.ile?.id);
        this.ileService.findById(resp.ile?.id).subscribe(resp2 => {
          console.log('resp2 :>> ', JSON.stringify(resp2));
          this.ile = resp2;
        });
      }
      else{
        this.ile = this.ileService.determineIle();
        console.log('this.ile :>> ', this.ile);
        resp.dateDebut = this.partieService.getPartie().dateDebut;
        // manque calcul durée partie (Date.now - dateDebut)
        resp.termine = false;
        resp.tresor = this.partieService.getPartie().tresor;
        resp.ile = this.ile;
        resp.joueur = this.joueur;
        resp.membres = this.partieService.getPartie().membres;
        this.partieService.setPartie(resp);
        this.partieService.update(resp).subscribe();
        console.log('this.joueur :>> ', this.joueur);
        console.log('this.partie :>> ', resp);
      }
    });

  }

  showIle() {
    if(this.ile){
      return `Nom : ${this.ile.nom} / Taverne : ${this.ile.taverne} / Chantier : ${this.ile.chantier} / Auberge :  ${this.ile.auberge} / Attente : ${this.ile.attente} / Ordre : ${this.ile.ordre} / Mer : ${this.ile.mer}`
    }
    else{
      return null;
    }  
  }

  rest(membre : Membre) {
    //check si pv max
    if(membre.pv) membre.pv += 1;
    this.membreService.update(membre).subscribe();
    this.joursRestants--;
    console.log(membre," a été reposé");
  }

  recruit() {}

  repair() {}

  buyShip() {}

  leave() {}
}
