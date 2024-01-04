import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Action, Bateau, Ile, Joueur, Membre, Navire, Partie, Pirate } from '../model';
import { PartieService } from '../partie.service';
import { StartComponent } from '../start/start.component';
import { IleService } from '../ile.service';
import { MembreService } from '../membre.service';
import { PirateService } from '../pirate.service';
import { NavireService } from '../navire.service';
import { BateauService } from '../bateau.service';
import { Router } from '@angular/router';

@Component({
  selector: 'ile',
  templateUrl: './ile.component.html',
  styleUrls: ['./ile.component.css'],
})
// TODO : ajouter stats équipage
export class IleComponent {
  joueur!: Joueur;
  partie!: Partie;
  ile: Ile = new Ile();
  ileDestination: Ile = new Ile();
  joursRestants!: number;
  pirates!: Pirate[];
  bateaux!: Bateau[];
  navire!: Navire;
  destinations!: Ile[];
  constructor(
    private authService: AuthService,
    private partieService: PartieService,
    private ileService: IleService,
    private membreService: MembreService,
    private pirateService: PirateService,
    private navireService: NavireService,
    private bateauService: BateauService,
    private router: Router
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie() as Partie;
    this.ile = this.partie.ile as Ile;
    console.log('this.ile constructeur ile component :>> ', this.ile);
    //this.partie.joursRestants = this.ile.attente as number;
    console.log('this.ile constructeur ile component :>> ', this.ile);
    console.log('this.partie constructeur partie component :>> ', this.ile);
    this.showIle();
    this.listRecruits();
    this.listBateaux();
    this.listDestinations();
    console.log('Constructeur de ile component, hors du subscribe');
    console.log('Constructeur ile component this.partie :>> ', this.partie);
  }

  showIle() {
    return `Nom : ${this.ile.nom} / Taverne : ${this.ile.taverne} / Chantier : ${this.ile.chantier} / Auberge :  ${this.ile.auberge} / Attente : ${this.ile.attente} / Ordre : ${this.ile.ordre} / Mer : ${this.ile.mer}`;
  }

  getNextMer(nom: string): string {
    switch (nom) {
      case 'EastBlue':
        return 'WestBlue';
        break;
      case 'WestBlue':
        return 'NorthBlue';
        break;
      case 'NorthBlue':
        return 'SouthBlue';
        break;
      case 'SouthBlue':
        return 'GrandLine';
        break;
      case 'GrandLine':
        return 'NewWorld';
        break;
      default:
        return '-1';
        break;
    }
  }

  listDestinations() {
    if (this.partie.ile) {
      if (this.partie.ile.ileFinale) {
        console.log(
          '[listDestinations() dans ile.component.ts] Ile finale, affichage des premières îles de la mer suivante'
        );
        this.ileService
          .findAllFirstIlesNextMer(
            this.getNextMer(this.partie.ile.mer as string)
          )
          .subscribe((resp) => {
            console.log('findAllFirstIlesNextMer() resp :>> ', resp);
            this.destinations = resp;
          });
      } else {
        console.log(
          '[listDestinations() dans ile.component.ts] Ile non finale, affichage des prochaines îles de la même mer'
        );
        this.ileService
          .findAllNextIlesSameMer(
            this.partie.ile.mer as string,
            (this.partie.ile.ordre as number) + 1
          )
          .subscribe((resp) => {
            console.log('findAllNextIlesSameMer() resp :>> ', resp);
            this.destinations = resp;
          });
      }
    }
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
      // this.partie.joursRestants!--;
      this.nextDay();
      console.log(membre, ' a été reposé');
    } else {
      console.log('Le pirate a déjà ses PV au max');
    }
  }

  listRecruits() {
    // TODO : plutôt faire une requête HTTP dédiée qui ramène direct les bons pirates
    this.pirateService.findAll().subscribe((resp) => {
      this.pirates = resp;
      // retire capitaines
      this.pirates = this.pirates.filter((pirate) => pirate.capitaine == false);
      // TODO : retirer pirates déjà membres de l'équipage
    });
  }

  recruit(pirate: Pirate) {
    if (
      this.partie.tresor &&
      pirate.prime &&
      this.partie.tresor >= pirate.prime
    ) {
      this.partie.tresor -= pirate.prime;
      let newMembre: Membre = new Membre();
      newMembre.pirate = pirate;
      newMembre.pv = pirate.pv;
      newMembre.power = pirate.power;
      newMembre.partie = this.partie;
      this.membreService.create(newMembre).subscribe((resp) => {
        this.partie.membres.push(resp);
        this.partieService.getForceTotale();
        // this.partie.joursRestants!--;
        this.nextDay();
        this.partieService.update(this.partie).subscribe(() => {
          this.partieService.savePartieInStorage(this.partie);
        });
        console.log(pirate, ' a été recruté');
        console.log('this.partie :>> ', this.partie);
        this.listRecruits();
      });
    } else {
      console.log("Pas assez d'argent pour recruter ce pirate");
    }
  }

  listBateaux() {
    this.bateauService.findAll().subscribe((resp) => {
      this.bateaux = resp;
      // si ile de départ, n'affiche que les bateaux de départ
      if (this.ile.id == 1) {
        this.bateaux.filter((bateau) => bateau.debut == true);
      }
      // TODO : retirer bateau déjà possédé
    });
  }

  buyShip(bateau: Bateau) {
    if (
      this.partie.tresor &&
      bateau.prix &&
      this.partie.tresor >= bateau.prix
    ) {
      this.partie.tresor -= bateau.prix;
      let newNavire: Navire = new Navire();
      newNavire.bateau = bateau;
      newNavire.robustesse = bateau.robustesse;
      this.navireService.create(newNavire).subscribe((resp) => {
        this.navire = resp;
        this.partie.navire = this.navire;
        // this.partie.joursRestants!--;
        this.nextDay();
        this.partieService.update(this.partie).subscribe(() => {
          this.partieService.savePartieInStorage(this.partie);
        });
        console.log(bateau, ' a été acheté');
        console.log('this.partie :>> ', this.partie);
        this.listBateaux();
      });
    }
  }
  repair() {
    if (this.partie.navire && this.partie.tresor && this.partie.tresor >= 5) {
      if (
        this.navire.bateau &&
        this.navire.bateau.robustesse &&
        this.navire.robustesse &&
        this.navire.robustesse < this.navire.bateau?.robustesse
      ) {
        this.navire.robustesse += 2;
        this.partie.tresor -= 5;
        if (this.navire.robustesse > this.navire.bateau.robustesse) {
          this.navire.robustesse = this.navire.bateau.robustesse;
        }
        console.log(this.navire, ' a été réparé');
      } else {
        console.log('Le navire a déjà sa robustesse au maximum');
      }
      this.navireService.update(this.navire).subscribe(() => {
        // this.partie.joursRestants!--;
        this.nextDay();
        this.partieService.update(this.partie).subscribe(() => {
          this.partieService.savePartieInStorage(this.partie);
        });
        console.log('this.partie :>> ', this.partie);
      });
    }
  }

  nextDay() {
    this.partie.joursRestants!--;
    (this.partie.duree as number) += 1;
    this.partieService.update(this.partie).subscribe(() => {
      this.partieService.savePartieInStorage(this.partie);
    });
  }

  leave(destination: Ile) {
    //TODO : créer la liste d'actions à utiliser pendant le trajet, et le save dans le Local Storage
    this.partie.ile = destination;
    this.partie.joursRestants = destination.attente;
    //petit test pour éviter le crash quand on arrive sur trajet si pas d'actions
    this.partie.actions.push(new Action())
    this.partieService.update(this.partie).subscribe(() => {
      this.partieService.savePartieInStorage(this.partie);      
      this.router.navigate(['/trajet']);
    });
  }
}
