import { Component } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Joueur, Membre } from '../model';
import { MembreService } from '../membre.service';
import { NavireService } from '../navire.service';
import { PartieService } from '../partie.service';

@Component({
  selector: 'stat-equipage',
  templateUrl: './stat-equipage.component.html',
  styleUrls: ['./stat-equipage.component.css']
})
export class StatEquipageComponent {
joueur!: Joueur;
vie?: number;
nbMembre: number = 0;
robustesse?: number;
force: number = 0;
tresor?: number;
nom!: string;
color: string = "#2C75FF";
visible: boolean = false;
membres!: Membre[]; 

  /*constructor(private membreService: MembreService, private navireService: NavireService) {
    this.load();
  }

  load() {
    // aller choper liste des membres de la partie grâce au partie service, genre : this.partieService.getPartie().getMembres
    console.log("avant");
    this.membreService.findAll().subscribe(resp => {
      console.log("entrer");
      this.membres = resp;
      console.log(this.membres); 
      this.nbMembre=this.membres.length;
      this.vie=this.membres[0].pv;
      this.tresor=this.membres[0].partie?.tresor;
      for (let membre of this.membres){
        if (membre.power){this.force+=membre.power;};
      }
    });
    this.navireService.findById(1).subscribe(resp => {
      this.robustesse = resp.robustesse;
    });
  }*/

  constructor (private partieService: PartieService){
    let user = localStorage.getItem('user')
    if(user){
    this.joueur = JSON.parse(user) as Joueur;
    this.load();
    }
  }

  load(){
    console.log("joueur : " + this.joueur.id);
    this.partieService.findByIdJoueurWithMembres(this.joueur.id).subscribe(resp => {
      this.membres=resp.membres;
      console.log("members : " +  JSON.stringify(this.membres))
      this.nbMembre=this.membres.length;
      console.log("nbMembre : " + this.nbMembre)
      this.vie=this.membres[0].pv;
      console.log("vie : " + this.vie)
      this.tresor=resp.tresor;
      console.log("tresor : " + this.tresor)
      for (let membre of this.membres){
        if (membre.power){this.force+=membre.power;};
      }
      console.log("power : " + this.force);
      console.log(`navire : ${resp.navire}`)
      this.robustesse=resp.navire?.robustesse;
      console.log("robustesse : " + this.robustesse);
    });
  }

  list(): Membre[] {
    return this.membres;
  }

  afficheMembre(){
    // if (this.visible){this.visible=false;}
    // else {this.visible=true;}

    this.visible = !this.visible;
  }

}
