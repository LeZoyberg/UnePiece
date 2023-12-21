import { Component } from '@angular/core';
import { Partie } from '../model';
import { PartieService } from '../partie.service';

@Component({
  selector: 'accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent {

constructor(private partieService:PartieService) {}

newGame() {
  this.partieService.create(new Partie()).subscribe();
}

}
