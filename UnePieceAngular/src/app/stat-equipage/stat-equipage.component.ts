import { Component } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Membre } from '../model';
import { MembreService } from '../membre.service';
import { NavireService } from '../navire.service';

@Component({
  selector: 'stat-equipage',
  templateUrl: './stat-equipage.component.html',
  styleUrls: ['./stat-equipage.component.css']
})
export class StatEquipageComponent {
vie?: number;
nbMembre: number = 0;
robustesse?: number;
force: number = 0;
tresor?: number;
nom!: string;
color: string = "#2C75FF";
visible: boolean = false;
membres!: Membre[]; 

  constructor(private membreService: MembreService, private navireService: NavireService) {
    this.load();
  }

  load() {
    // aller choper liste des membres de la partie grâce au partie service, genre : this.partieService.getPartie().getMembres
    this.membreService.findAll().subscribe(resp => {
      this.membres = resp;
      this.nbMembre=this.membres.length;
      this.vie=this.membres[0].pv;
      this.tresor=this.membres[0].partie?.tresor;
      for (let membre of this.membres){
        if (membre.power){this.force+=membre.power;};
      }
    });
    this.navireService.findById().subscribe(resp => {
      this.robustesse = resp.robustesse;
    });
  }

  list(): Membre[] {
    if(!this.membres) {
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
