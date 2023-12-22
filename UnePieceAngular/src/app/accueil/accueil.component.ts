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
  this.partieService.create(new Partie()).subscribe(resp => {
    this.partie = resp;
    this.partie.duree = 0;
    this.partie!.joueur = this.authService.getUtilisateur();
    this.partieService.update(this.partie);
    this.router.navigate(['/start']);
  });
}

}
