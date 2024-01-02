import { Component } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Membre } from '../model';
import { MembreService } from '../membre.service';

@Component({
  selector: 'stat-equipage',
  templateUrl: './stat-equipage.component.html',
  styleUrls: ['./stat-equipage.component.css']
})
export class StatEquipageComponent {
vie: number = 1;
nbMembre: number = 0;
robustesse: number = 3;
force: number = 4;
tresor: number = 5;
nom!: string;
color: string = "#2C75FF";
visible: boolean = false;
membres!: Membre[]; 

  constructor(private membreService: MembreService) {
    this.load();
  }

  load() {
    // aller choper liste des membres de la partie grâce au partie service, genre : this.partieService.getPartie().getMembres
    this.membreService.findAll().subscribe(resp => {
      this.membres = resp;
      this.nbMembre=this.membres.length;
    });
    console.log('this.membres :>> ', this.membres);
  }

  list(): Membre[] {
    if(!this.membres) {
      console.log("pas de membres trouvés, -> this.load()");
      this.load();
    }
    return this.membres;
  }

  afficheMembre(){
    // if (this.visible){this.visible=false;}
    // else {this.visible=true;}

    this.visible = !this.visible;
  }

}
