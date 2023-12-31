import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import {
  Action,
  Bateau,
  Ile,
  Joueur,
  Membre,
  Navire,
  Partie,
  Pirate,
} from '../model';
import { PartieService } from '../partie.service';
import { StartComponent } from '../start/start.component';
import { IleService } from '../ile.service';
import { MembreService } from '../membre.service';
import { PirateService } from '../pirate.service';
import { NavireService } from '../navire.service';
import { BateauService } from '../bateau.service';
import { ActionService } from '../action.service';
import { EventService } from '../event.service';
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
  actionTrajet!: Action;
  constructor(
    private authService: AuthService,
    private partieService: PartieService,
    private ileService: IleService,
    private membreService: MembreService,
    private pirateService: PirateService,
    private navireService: NavireService,
    private bateauService: BateauService,
    private actionService: ActionService,
    private eventService: EventService,
    private router: Router
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie() as Partie;
    this.ile = this.partie.ile as Ile;
    this.showIle();
    this.listBateaux();
    this.listRecruits();
    this.listDestinations();
    this.partieService.checkEndOfGame();
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
        return 'END';
        break;
    }
  }

  listDestinations() {
    if (this.partie.ile) {
      if (this.partie.ile.ileFinale) {
        if (this.getNextMer(this.partie.ile.mer as string) != 'END') {
          this.ileService
            .findAllFirstIlesNextMer(
              this.getNextMer(this.partie.ile.mer as string)
            )
            .subscribe((resp) => {
              this.destinations = resp;
            });
        } else {
          this.router.navigate(['/ending']);
        }
      } else {
        this.ileService
          .findAllNextIlesSameMer(
            this.partie.ile.mer as string,
            (this.partie.ile.ordre as number) + 1
          )
          .subscribe((resp) => {
            this.destinations = resp;
          });
      }
    }
  }

  rest(membre: Membre) {
    if (membre.pv! < membre.pirate!.pv!) {
      membre.pv! += 1;
      this.membreService.update(membre).subscribe();
      this.nextDay();
      alert(membre.pirate!.nom + ' a été reposé');
    } else {
      alert(membre.pirate!.nom + ' a déjà ses PV au max');
    }
  }

  listRecruits() {
    this.pirateService.getRandomRecruits().subscribe((resp) => {
      this.pirates = resp;
      for (let m of this.partie.membres) {
        this.pirates = this.pirates.filter((p) => p.id !== m.pirate!.id);
      }

      const uniquePirates = this.getUniquePirates(this.pirates);

      this.pirates = uniquePirates;
    });
  }

  getUniquePirates(pirates: Pirate[]): Pirate[] {
    const uniquePirates: Pirate[] = [];
    const seenIDs: Set<number> = new Set();

    for (const pirate of pirates) {
      if (!seenIDs.has(pirate.id!)) {
        uniquePirates.push(pirate);
        seenIDs.add(pirate.id!);
      }
    }

    return uniquePirates;
  }

  recruit(pirate: Pirate) {
    if (this.partie.membres.length < this.partie.navire?.bateau?.capacite!) {
      if (this.partie.tresor! >= pirate.prime!) {
        this.partie.tresor! -= pirate.prime!;
        let newMembre: Membre = new Membre();
        newMembre.pirate = pirate;
        newMembre.pv = pirate.pv;
        newMembre.power = pirate.power;
        newMembre.partie = this.partie;
        this.membreService.create(newMembre).subscribe((resp) => {
          this.partie.membres.push(resp);
          this.partieService.getForceTotale();
          this.nextDay();
          this.partieService.update(this.partie).subscribe(() => {
            this.partieService.savePartieInStorage(this.partie);
          });
          alert(pirate.nom + ' a été recruté');
        });
      } else {
        alert('Tu es trop pauvre mon gueux !');
      }
    } else {
      alert('Plus de place à bord !');
    }
  }

  getUniqueBateaux(bateaux: Bateau[]): Bateau[] {
    const uniqueBateaux: Bateau[] = [];
    const seenIDs: Set<number> = new Set();

    for (const bateau of bateaux) {
      if (!seenIDs.has(bateau.id!)) {
        uniqueBateaux.push(bateau);
        seenIDs.add(bateau.id!);
      }
    }
    return uniqueBateaux;
  }

  listBateaux() {
    this.bateauService
      .getRandomBateaux(this.partie.ile!.id!)
      .subscribe((resp) => {
        this.bateaux = resp;
        console.log('this.bateaux resp :>> ', this.bateaux);
        for (let b of this.bateaux) {
          this.bateaux = this.bateaux.filter(
            (b) => b.id !== this.partie.navire?.bateau!.id
          );
        }
        const uniqueBateaux = this.getUniqueBateaux(this.bateaux);
        this.bateaux = uniqueBateaux;
        console.log('this.bateaux après tous les filtres :>> ', this.bateaux);
      });

    // this.bateauService.findAll().subscribe((resp) => {
    //   this.bateaux = resp;
    //   // si ile de départ, n'affiche que les bateaux de départ
    //   if (this.ile.id == 1) {
    //     this.bateaux.filter((bateau) => bateau.debut == true);
    //   }
    //   // TODO : retirer bateau déjà possédé
    // });
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
        this.nextDay();
        this.partieService.update(this.partie).subscribe(() => {
          this.partieService.savePartieInStorage(this.partie);
        });
      });
    }
  }
  repair() {
    if (this.partie.tresor! >= 5) {
      if (
        this.partie.navire!.robustesse! <
        this.partie.navire!.bateau?.robustesse!
      ) {
        this.partie.navire!.robustesse! += 2;
        this.partie.tresor! -= 5;
        if (
          this.partie.navire!.robustesse! >
          this.partie.navire!.bateau!.robustesse!
        ) {
          this.partie.navire!.robustesse =
            this.partie.navire!.bateau!.robustesse;
        }
        alert(this.partie.navire!.bateau!.nom + ' a été réparé');
      } else {
        alert(
          this.partie.navire!.bateau!.nom +
            ' a déjà sa robustesse au maximum ! Vous passez la journée à essayer de le réparer en vain ...'
        );
      }
      this.navireService.update(this.partie.navire!).subscribe(() => {
        this.nextDay();
        this.partieService.update(this.partie).subscribe(() => {
          this.partieService.savePartieInStorage(this.partie);
        });
      });
    }
  }

  nextDay() {
    this.listRecruits();
    this.listBateaux();
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
    this.setAction();
  }

  setAction() {
    for (let i = 1; i <= this.partie.joursRestants!; i++) {
      this.actionTrajet = new Action();
      var idEvent: number = Math.floor(Math.random() * 14) + 1;
      this.eventService.findById(idEvent).subscribe((resp) => {
        this.actionTrajet.event = resp;
        this.actionTrajet.degatMembre =
          resp.degatMembre! * (this.partie.ile?.dangerosite as number);
        this.actionTrajet.degatNavire =
          resp.degatNavire! * (this.partie.ile?.dangerosite as number);
        this.actionTrajet.tresor =
          resp.tresor! * (this.partie.ile?.dangerosite as number);
        this.actionTrajet.partie = this.partie;
        this.actionTrajet.termine = false;
        this.actionService.create(this.actionTrajet).subscribe((resp2) => {
          this.partie.actions.push(resp2);
          console.log(i);
          console.log(this.actionTrajet);
          this.partieService.update(this.partie).subscribe(() => {
            this.partieService.savePartieInStorage(this.partie);
            this.router.navigate(['/trajet']);
          });
        });
      });
    }
  }
}
