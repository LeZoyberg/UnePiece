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
nbMembre!: number;
robustesse: number = 3;
force: number = 4;
tresor: number = 5;
nom!: string;
color: string = "#2C75FF";
visible: boolean = false;
membres!: Observable<Membre[]>; 

  constructor(private membreService: MembreService) {
    this.load();
  }

  load() {
    this.membres = this.membreService.findAll();
    for (let m of [this.membres]){this.nbMembre++;}
  }

  list(): Observable<Membre[]> {
    return this.membres;
  }

  afficheMembre(){
    if (this.visible){this.visible=false;}
    else {this.visible=true;}
  }

}
