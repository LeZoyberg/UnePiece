import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Joueur, Membre, Partie } from '../model';
import { PartieService } from '../partie.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'stat-equipage',
  templateUrl: './stat-equipage.component.html',
  styleUrls: ['./stat-equipage.component.css']
})
export class StatEquipageComponent {
joueur!: Joueur;
force: number = 0;
color: string = "#2C75FF";
visible: boolean = false;
partie!: Partie;

  constructor (private partieService: PartieService, private authService: AuthService){
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie(this.joueur);
    if(this.partie) {
      this.load();
    } else {
      this.partieService.getPartieFromDb(this.joueur).subscribe(resp => {
        this.partie = resp;
        this.load();
      })
    }
  
  }
  load() {
    console.log('this.partie stat-equipage :>> ', this.partie);
  }
  list(): Membre[] {
    return this.partie.membres;
  }

  afficheMembre(){
    this.visible = !this.visible;
  }

}
