import { Component } from '@angular/core';
import { Action, Partie } from '../model';
import { IleService } from '../ile.service';
import { PartieService } from '../partie.service';

@Component({
  selector: 'action',
  templateUrl: './action.component.html',
  styleUrls: ['./action.component.css']
})
export class ActionComponent {
  partie: Partie = new Partie;
  action: Action = new Action;
  visible?: boolean = true;
  text?: string;
  title?: string = "Faites Face";
  title1?: string;
  title2?: string;


  constructor(
    private ileService: IleService,
    private partieService: PartieService,
  ) {
    this.partie = this.partieService.getPartie() as Partie;
    this.action = this.partie.actions.shift() as Action;

    this.checkForText(this.action.event?.odyssee as string);

    this.partieService.update(this.partie).subscribe(() => {
      this.partieService.savePartieInStorage(this.partie);
    });   
  }

  checkForText(nom : string){
    switch (nom) {
      case 'Monstre':
        this.text = 'Un monstre marin jaillit devant vous !';
        this.title1 = "Affronter";
        this.title2 = "Fuir";
        break;
      case 'Tempete':
        this.visible = false;
        this.text = 'Accrochez vous matelots, la tempête vient droit sur nous !!';
        break;
      case 'Restaurant':
        this.text = 'Qui a une petite faim ?';
        this.title1 = "Restaurer";
        this.title2 = "Continuer";
        break;
      case 'Tresor':
        this.text = "Une île mystérieuse ... un trésor s'y cache peut-être";
        this.title1 = "Explorer";
        this.title2 = "Continuer";
        break;
      case 'Bataille':
        this.text = 'Un féroce équipage vous fait face et semble vouloir en découdre !';
        this.title1 = "Combattre";
        this.title2 = "Fuir";
        break;
    }
  }

}
