import { Component } from '@angular/core';
import { Action, Partie } from '../model';
import { IleService } from '../ile.service';
import { PartieService } from '../partie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'action',
  templateUrl: './action.component.html',
  styleUrls: ['./action.component.css'],
})
export class ActionComponent {
  partie: Partie = new Partie();
  action: Action = new Action();
  visible?: boolean = true;
  text?: string;
  title?: string = 'Faites Face';
  title1?: string;
  title2?: string;

  constructor(
    private ileService: IleService,
    private partieService: PartieService,
    private router: Router
  ) {
    this.partie = this.partieService.getPartie() as Partie;
    this.action = this.partie.actions.shift() as Action;
    this.checkForText(this.action.event?.odyssee as string);

    this.partieService.update(this.partie).subscribe(() => {
      this.partieService.savePartieInStorage(this.partie);
    });
  }

  checkForText(nom: string) {
    switch (nom) {
      case 'Monstre':
        this.text = 'Un monstre marin jaillit devant vous !';
        this.title1 = 'Affronter';
        this.title2 = 'Fuir';
        break;
      case 'Tempete':
        this.visible = false;
        this.text =
          'Accrochez vous matelots, la tempête vient droit sur nous !!';
        break;
      case 'Restaurant':
        this.text = 'Qui a une petite faim ?';
        this.title1 = 'Restaurer';
        this.title2 = 'Continuer';
        break;
      case 'Tresor':
        this.text = "Une île mystérieuse ... un trésor s'y cache peut-être";
        this.title1 = 'Explorer';
        this.title2 = 'Continuer';
        break;
      case 'Bataille':
        this.text =
          'Un féroce équipage vous fait face et semble vouloir en découdre !';
        this.title1 = 'Combattre';
        this.title2 = 'Fuir';
        break;
    }
  }

  suite() {
    if (this.partie.joursRestants! > 1) {
      this.partie.joursRestants!--;
      this.partie.duree!++;
      this.partieService.update(this.partie).subscribe(() => {
        this.action = this.partie.actions.shift() as Action;
        this.checkForText(this.action.event?.odyssee as string);
        this.partieService.savePartieInStorage(this.partie);
      });
    } else {
      this.partie.joursRestants = this.partie.ile?.attente;
      this.partie.duree!++;
      this.partieService.update(this.partie).subscribe(() => {
        this.partieService.savePartieInStorage(this.partie);
        this.router.navigate(['/ile']);
      });
    }
    this.partieService.checkEndOfGame();
  }

  bouton1() {
    if (this.partie.tresor! + this.action.tresor! < 0) {
      alert("Pas assez d'argent pour cette action !")
    }
    else {
      this.partie.membres.forEach((membre, index) => {
        membre.pv! -= this.action.degatMembre!;
        this.partieService.checkPvMembre(membre, index);
      });
      this.partie.navire!.robustesse! -= this.action.degatNavire!;
      this.partie.tresor! += this.action.tresor!;
      this.suite();
    }
  }

  bouton2() {
    this.suite();
  }

  boutonTempete() {
    this.partie.membres.forEach((membre, index) => {
      membre.pv! -= this.action.degatMembre!;
      this.partieService.checkPvMembre(membre, index);
    });
    this.partie.navire!.robustesse! -= this.action.degatNavire!;
    this.visible = true;
    this.suite();
  }
}
