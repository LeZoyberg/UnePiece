import { Component } from '@angular/core';
import { Partie } from '../model';
import { PartieService } from '../partie.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
@Component({
  selector: 'accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent {

partie?:Partie;

constructor(private partieService:PartieService, private router: Router, private authService:AuthService) {

}

newGame() {
  this.partie = new Partie();
  this.partie.termine = false;
  this.partie!.joueur = this.authService.getUtilisateur();
  this.partie.duree = 0;
  this.partie.dateDebut = new Date(Date.now()).toISOString().substr(0,10);
  this.partieService.create(this.partie).subscribe(resp => {
    this.router.navigate(['/start']);
    console.log('this.partie :>> ', this.partie);
  });
}

}
