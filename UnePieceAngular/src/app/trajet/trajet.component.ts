import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PartieService } from '../partie.service';
import { Joueur, Partie } from '../model';

@Component({
  selector: 'app-trajet',
  templateUrl: './trajet.component.html',
  styleUrls: ['./trajet.component.css']
})
export class TrajetComponent {
nbJours: number = 3;
ile?: number;
joueur!: Joueur;

  constructor(
    private router: Router,
    private partieService: PartieService,
  ) {
    let user = localStorage.getItem('user')
    if(user){
      this.joueur = JSON.parse(user) as Joueur;
      this.partieService.findByIdJoueur(this.joueur.id).subscribe(resp => {
        console.log("ile id"+resp.ile?.id)
        this.ile = resp.ile?.id as number;
      });
    };
  }

Suite(){
  if (!(this.nbJours==0)){
    this.nbJours--;
  }
  else{
    this.nbJours=3;
    console.log(`this ile id ${this.ile}`);
    this.router.navigate(['/ile/'+this.ile]);
  }
}

}
