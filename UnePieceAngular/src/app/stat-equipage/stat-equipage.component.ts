import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Joueur, Membre, Partie } from '../model';
import { MembreService } from '../membre.service';
import { NavireService } from '../navire.service';
import { PartieService } from '../partie.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'stat-equipage',
  templateUrl: './stat-equipage.component.html',
  styleUrls: ['./stat-equipage.component.css']
})
export class StatEquipageComponent {
joueur!: Joueur;
// vie?: number;
// nbMembre: number = 0;
// robustesse?: number;
force: number = 0;
// tresor?: number;
// nom!: string;
color: string = "#2C75FF";
visible: boolean = false;
// membres!: Membre[]; 
partie!: Partie;

  constructor (private partieService: PartieService, private authService: AuthService){
    // let user = localStorage.getItem('user')
    // if(user){
    // this.joueur = JSON.parse(user) as Joueur;
    // this.load();
    // }
    
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie() as Partie;
    // this.nbMembre = this.partie.membres.length;
    this.partieService.getForceTotale();  
  }

  
  // load(){
  //   this.partieService.findByIdJoueurWithMembres(this.joueur.id).subscribe(resp => {
      
  //     this.membres=resp.membres;
  //     this.nbMembre=this.membres.length;
  //     this.vie=this.membres[0].pv;
  //     this.tresor=resp.tresor;
     
  //     //console.log(`navire : ${resp.navire}`)
  //     this.robustesse=resp.navire?.robustesse;
  //   });
  // }

  list(): Membre[] {
    return this.partie.membres;
  }

  afficheMembre(){
    // if (this.visible){this.visible=false;}
    // else {this.visible=true;}

    this.visible = !this.visible;
  }

}
