import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Bateau, Ile, Joueur, Membre, Navire, Partie, Pirate } from '../model';
import { PartieService } from '../partie.service';
import { StartComponent } from '../start/start.component';
import { IleService } from '../ile.service';
import { MembreService } from '../membre.service';
import { PirateService } from '../pirate.service';
import { NavireService } from '../navire.service';
import { BateauService } from '../bateau.service';

@Component({
  selector: 'ile',
  templateUrl: './ile.component.html',
  styleUrls: ['./ile.component.css'],
})
export class IleComponent {
  joueur: Joueur = this.authService.getUtilisateur() as Joueur;
  partie: Partie = this.partieService.getPartie();
  ile: Ile = new Ile();
  idIle!: number;
  joursRestants!: number;
  pirates!: Pirate[];
  bateaux!: Bateau[];
  navire!:Navire;
  constructor(
    private authService: AuthService,
    private partieService: PartieService,
    private ileService: IleService,
    private membreService: MembreService,
    private pirateService: PirateService,
    private navireService: NavireService,
    private bateauService: BateauService,
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partieService.findByIdJoueur(this.joueur.id).subscribe((resp) => {
      this.ile = this.ileService.determineIle();
      console.log('this.ile :>> ', this.ile);
      this.partie = resp;
      this.partie.dateDebut = this.partieService.getPartie().dateDebut;
      // TODO : manque calcul durée partie (Date.now - dateDebut)
      this.partie.termine = false;
      this.partie.tresor = this.partieService.getPartie().tresor;
      this.partie.ile = this.ile;
      this.joursRestants = this.ile.attente as number;
      this.partie.joueur = this.joueur;
      this.partie.membres = this.partieService.getPartie().membres;
      this.partieService.setPartie(this.partie);
      this.partieService.update(this.partie).subscribe();
      this.listRecruits();
      this.listBateaux();
      console.log('this.joueur :>> ', this.joueur);
      console.log('this.partie :>> ', this.partie);
    });
  }
  showIle() {
    return `Nom : ${this.ile.nom} / Taverne : ${this.ile.taverne} / Chantier : ${this.ile.chantier} / Auberge :  ${this.ile.auberge} / Attente : ${this.ile.attente} / Ordre : ${this.ile.ordre} / Mer : ${this.ile.mer}`;
  }

  rest(membre: Membre) {
    if (
      membre.pv &&
      membre.pirate &&
      membre.pirate.pv &&
      membre.pv < membre.pirate.pv
    ) {
      membre.pv += 1;
      this.membreService.update(membre).subscribe();
      this.joursRestants--;
      console.log(membre, ' a été reposé');
    }
  }

  listRecruits() {
    this.pirateService.findAll().subscribe((resp) => {
      this.pirates = resp;
      // retire capitaines
      this.pirates = this.pirates.filter((pirate) => pirate.capitaine == false);
      // TODO : retirer pirates déjà membres de l'équipage
    });
  }

  recruit(pirate: Pirate) {
    let newMembre: Membre = new Membre();
    newMembre.pirate = pirate;
    newMembre.pv = pirate.pv;
    newMembre.power = pirate.power;
    newMembre.partie = this.partie;
    this.membreService.create(newMembre).subscribe((resp) => {
      this.partie.membres.push(resp);
      this.partieService.update(this.partie).subscribe();
      this.joursRestants--;
      console.log(pirate, ' a été recruté');
      console.log('this.partie :>> ', this.partie);
      this.listRecruits();
    });
  }

  listBateaux() {
    this.bateauService.findAll().subscribe((resp) => {
      this.bateaux = resp;
      // si ile de départ, n'affiche que les bateaux de départ
      if(this.ile.id == 1) {
        this.bateaux.filter(bateau => bateau.debut == true);
      }
      // TODO : retirer bateau déjà possédé
    });
  }

  buyShip(bateau : Bateau) {
    if(this.partie.tresor && bateau.prix && this.partie.tresor >= bateau.prix) {
      this.partie.tresor -= bateau.prix;

      let newNavire: Navire = new Navire();
      newNavire.bateau = bateau;
      newNavire.robustesse = bateau.robustesse;
      this.navireService.create(newNavire).subscribe(resp => {
        this.navire = resp;
        this.partie.navire = this.navire;
        this.partieService.update(this.partie).subscribe();
        this.joursRestants--;
        console.log(bateau, ' a été acheté');
        console.log('this.partie :>> ', this.partie);
        this.listBateaux();
      })
    }
  }
  repair() {
    if(this.partie.navire && this.partie.tresor && this.partie.tresor >= 5) {
      if(this.navire.bateau && this.navire.bateau.robustesse && this.navire.robustesse 
        && this.navire.robustesse < this.navire.bateau?.robustesse) {
          this.navire.robustesse += 2;
          this.partie.tresor -= 5;
          if(this.navire.robustesse > this.navire.bateau.robustesse) {
            this.navire.robustesse = this.navire.bateau.robustesse;
          }
          console.log(this.navire, " a été réparé");
        }
        else {
          console.log("Le navire a déjà sa robustesse au maximum");
        }
        this.navireService.update(this.navire).subscribe(resp => {
          this.partieService.update(this.partie).subscribe();
          console.log('this.partie :>> ', this.partie);
        })
    }
  }
  leave() {}
}
