import { Component } from '@angular/core';
import { Action, Partie } from '../model';
import { IleService } from '../ile.service';
import { PartieService } from '../partie.service';
import { Router } from '@angular/router';
import { ActionService } from '../action.service';

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
    private actionService: ActionService,
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
      this.action = this.partie.actions.shift() as Action;
     
      this.checkForText(this.action.event?.odyssee as string);
      this.partieService.update(this.partie).subscribe(() => {
        this.actionService.delete(this.action.id).subscribe(() => {
        
          this.partieService.savePartieInStorage(this.partie);
        });
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
    console.log('(this.action.event?.odyssee as string) :>> ', (this.action.event?.odyssee as string));
    
    if ((this.action.event?.odyssee as string) == 'Restaurant' &&
      this.partie.tresor! + this.action.tresor! < 0) {
      alert("Pas assez d'argent pour cette action !");
    } else {
      this.partie.membres.forEach((membre, index) => {
        membre.pv! -= this.action.degatMembre!;
        this.partieService.checkPvMembre(membre, index);
      });
      this.partie.navire!.robustesse! -= this.action.degatNavire!;
      this.partie.tresor! += this.action.tresor!;
      if(this.partie.tresor! < 0 ) {
        this.partie.tresor = 0;
      }
      this.suite();
    }
  }

  bouton2() {
    var degat: number = Math.floor(Math.random() * 4);
    //choisir aléatoirement degatnavire, degatmembre ou tresor et enlever le degat
    var alea: number = Math.floor(Math.random() *3)+1;
    if(alea==1){
      if (this.partie.tresor! == 0){
        alert ("Tu as de la chance d'être pauvre, tu n'as plus de Berry à perdre...")
      }
      else {
        this.partie.tresor! -= degat*2 ;
        alert ("Vous perdez "+(degat*2)+"฿")
        if (this.partie.tresor! <= 0){
          this.partie.tresor = 0;
          alert ("Tu es maintenant pauvre, gueux.")
        }
      }
    }
    if(alea==2){
      this.partie.navire!.robustesse! -= degat ;
      alert ("Votre navire prend "+degat+" de dégâts")
    }
    if(alea==3){
      this.partie.membres.forEach((membre, index) => {
        membre.pv! -= degat;
        this.partieService.checkPvMembre(membre, index);
      });
      alert ("Vos membres perdent tous "+(degat)+"pv")
    }
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
