import { Component } from '@angular/core';
import { PirateService } from '../pirate.service';
import { Joueur, Partie, Pirate } from '../model';
import { PartieService } from '../partie.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css'],
})
export class StartComponent {
  capitaines: Pirate[] = [];
  joueur: Joueur = {};
  partie: Partie = {};
  constructor(
    private pirateService: PirateService,
    private partieService: PartieService,
    private authService: AuthService
  ) {
    this.listCapitaines();
    this.joueur = this.authService.getUtilisateur() as Joueur;
  }

  listCapitaines() {
    this.pirateService.findAll().subscribe((resp) => {
      this.capitaines = resp;
      this.capitaines = this.capitaines.filter(
        (pirate) => pirate.capitaine == true
      );
    });
  }
  chooseCapitaine(capitaine:Pirate) {
    this.partieService.findByIdJoueur(this.joueur.id).subscribe(resp => {
      this.partie = resp;
      this.partie.membres?.push(capitaine);
      this.partie.tresor = capitaine.prime;
      console.log('capitaine :>> ', capitaine);
      console.log('this.partie :>> ', this.partie);
    });

  }
}
