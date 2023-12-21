import { Component } from '@angular/core';
import { Partie } from '../model';
import { PartieService } from '../partie.service';
import { Router } from '@angular/router';
@Component({
  selector: 'accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent {

constructor(private partieService:PartieService, private router: Router) {}

newGame() {
  this.partieService.create(new Partie()).subscribe();
  this.router.navigate(['/start']);
}

}
