import { Component } from '@angular/core';
import { Ile, Joueur, Navire, Partie } from '../model';
import { PartieService } from '../partie.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { IleService } from '../ile.service';
import { BateauService } from '../bateau.service';
import { NavireService } from '../navire.service';
@Component({
  selector: 'accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css'],
})
export class AccueilComponent {
  joueur?: Joueur;
  partie?: Partie;
  parties?: Partie[];
  constructor(
    private partieService: PartieService,
    private router: Router,
    private authService: AuthService,
    private ileService: IleService,
    private bateauService: BateauService,
    private navireService: NavireService,
  ) {
    this.joueur = this.authService.getUtilisateur() as Joueur;
    this.partie = this.partieService.getPartie();
     if (!this.partie) {
      this.partieService.findByIdJoueurWithMembres(this.joueur.id).subscribe(resp =>{
        this.partie=resp;
      })
     } 
    console.log("this.partie :>>",this.partie)
    this.partieService.findAll().subscribe((resp) => {
      this.parties = resp;
      console.log('this.parties :>> ', this.parties);
    });
  }

  continueGame() {
    //console.log(this.joueur?.id);
    this.partieService
      .findByIdJoueurWithMembres(this.joueur?.id)
      ?.subscribe((resp) => {
        console.log(resp);
        if (resp && resp.termine == false) {
          console.log(
            '[continueGame() in accueil.component.ts] Une partie en cours a été trouvée pour ce joueur'
          );
          this.partie = resp;
          this.partie.forceTotale = 0;

          this.partie.joueur = this.joueur;
          this.partieService.savePartieInStorage(this.partie);
          console.log(
            '[continueGame() in accueil.component.ts] Partie en cours = this.partie :>> ',
            this.partie
          );
          this.router.navigate(['/ile']);
        } else this.newGame();
      });
  }

  newGame() {
    this.partie = new Partie();
    this.partie.termine = false;
    this.partie.joueur = this.joueur;
    this.partie.duree = 0;
    this.partie.dateDebut = new Date(Date.now()).toISOString().substr(0, 10);
    this.partie.forceTotale = 0;
    this.partie.joursRestants = 0;
    

    this.ileService.findById(1).subscribe((resp) => {
      if (this.partie) {
        this.partie.ile = resp;
        this.partie.joursRestants = this.partie.ile.attente;
        this.bateauService.findById(1).subscribe(bateau =>{
          let newNavire: Navire = new Navire();
          newNavire.bateau = bateau;
          newNavire.robustesse = bateau.robustesse;
          this.navireService.create(newNavire).subscribe((resp) => {
            this.partie!.navire = resp;
            this.partieService.create(this.partie!).subscribe((resp) => {
              console.log(
                '[newGame() in accueil.component.ts] this.partie :>> ',
                this.partie
              );
              if (this.partie) {
                this.partie.id = resp.id;
                this.partieService.savePartieInStorage(this.partie);
              }
              this.router.navigate(['/start']);
            });
          })
        })
      }
    });
  }
}
