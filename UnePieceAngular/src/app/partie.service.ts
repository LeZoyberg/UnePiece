import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Joueur, Membre, Partie } from './model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { MembreService } from './membre.service';
import { ActionService } from './action.service';
import { AuthService } from './auth.service';
@Injectable({
  providedIn: 'root',
})
export class PartieService {
  partie!: Partie;
  joueur!: Joueur;
  constructor(
    private http: HttpClient,
    private router: Router,
    private membreService: MembreService,
    private actionService: ActionService,
    private authService: AuthService
  ) {
    // this.joueur = this.authService.getUtilisateur() as Joueur;
    // if (this.partie) {
    //   this.load();
    // } else {
    //   this.getPartieFromDb(this.joueur).subscribe((resp) => {
    //     this.partie = resp;
    //     this.load();
    //   });
    // }
  }

  redirect(partie : Partie) {
    if(partie.termine == true) {
      this.router.navigate(['/ending']);
    } else if(!partie.membres) {
      this.router.navigate(['/start']);
    } else if(partie.actions.length > 0) {
      this.router.navigate(['/trajet']);
    } else if(partie.actions.length == 0) {
      this.router.navigate(['/ile']);
    }
  } 

  load() {
    console.log('this.partie partieService :>> ', this.partie);
  }

  getPartieFromDb(joueur: Joueur): Observable<Partie> {
    return this.http.get<Partie>(
      environment.apiUrl + '/partie/joueur/' + joueur.id + '/membres/actions'
    );
  }

  savePartieInStorage(partie: Partie) {
    // localStorage.setItem('partie', JSON.stringify(partie));
  }

  getPartie(joueur: Joueur): Partie {
    return this.partie;
  }

  setPartie(partie: Partie) {
    this.partie = partie;
  }

  findAll(): Observable<Partie[]> {
    return this.http.get<Partie[]>(environment.apiUrl + '/partie');
  }

  findById(id?: number): Observable<Partie> {
    return this.http.get<Partie>(environment.apiUrl + '/partie/' + id);
  }

  create(partie: Partie): Observable<Partie> {
    return this.http.post<Partie>(environment.apiUrl + '/partie', partie);
  }

  update(partie: Partie): Observable<Partie> {
    return this.http.put<Partie>(
      environment.apiUrl + '/partie/' + partie.id,
      partie
    );
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + '/partie/' + id);
  }

  findByIdJoueur(id?: number): Observable<Partie> {
    return this.http.get<Partie>(environment.apiUrl + '/partie/joueur/' + id);
  }

  findAllByIdJoueur(id: number): Observable<Partie[]> {
    return this.http.get<Partie[]>(
      environment.apiUrl + '/partie/historique/' + id
    );
  }

  findLeaderboard(): Observable<Partie[]> {
    return this.http.get<Partie[]>(environment.apiUrl + '/partie/leaderboard');
  }

  findByIdJoueurWithMembres(id?: number): Observable<Partie> {
    return this.http.get<Partie>(
      environment.apiUrl + '/partie/joueur/' + id + '/membres'
    );
  }

  findByIdJoueurWithMembresAndActions(id?: number): Observable<Partie> {
    return this.http.get<Partie>(
      environment.apiUrl + '/partie/joueur/' + id + '/membres/actions'
    );
  }

  getForceTotale() {
    this.partie.forceTotale = 0;
    for (let m of this.partie.membres) {
      (this.partie.forceTotale as number) += m.power as number;
    }
  }

  checkEndOfGame(partie: Partie) {
    if (
      (partie.membres && partie.membres[0].pv && partie.membres[0].pv <= 0) ||
      (partie.navire &&
        partie.navire.robustesse &&
        partie.navire.robustesse <= 0)
    ) {
      partie.termine = true;
      this.redirect(partie);
    }
    if (partie.ile!.nom == 'Ile4_NewWorld') {
      partie.termine = true;
      this.redirect(partie);
    }
  }

  checkHpOrDeathMembre(membre: Membre, index: number) {
    if (membre.pv! <= 0) {
      if (!membre.pirate!.capitaine) {
        this.membreService.delete(membre.id).subscribe();
        this.partie.membres.splice(index, 1);
        this.update(this.partie).subscribe(() => {
          this.savePartieInStorage(this.partie);
        });
      }
      alert(membre.pirate?.nom + ' est mort !');
    } else {
      if (membre.pv! > membre?.pirate?.pv!) {
        membre.pv = membre.pirate?.pv;
      }
      // this.membreService.update(membre).subscribe();
    }
  }
}
