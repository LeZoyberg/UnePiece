import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Joueur, Membre, Partie } from './model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { MembreService } from './membre.service';
import { ActionService } from './action.service';
@Injectable({
  providedIn: 'root',
})
export class PartieService {
  partie!: Partie;

  constructor(
    private http: HttpClient,
    private router: Router,
    private membreService: MembreService,
    private actionService: ActionService
  ) {}

  getPartie(joueur: Joueur): Partie | any {
    if (this.partie) {
      console.log('directly returning this.partie from partieService.ts');
      console.log('this.partie :>> ', this.partie);
      return this.partie;
    } 
    else {
      this.findByIdJoueurWithMembres(joueur.id).subscribe((partieResp) => {
        this.partie = partieResp;
        if (this.partie) {
          this.partie.membres = partieResp.membres;
          this.getForceTotale();
          this.actionService
            .findAllWithPartie(this.partie.id!)
            .subscribe((actionsResp) => {
              this.partie!.actions = actionsResp;
              this.setPartie(this.partie!);
              console.log(
                'returning this.partie after finding in db, getPartie partieService.ts :>>',
                this.partie
              );
              return this.partie;
            });
        }
      });
    }
  }

  savePartieInStorage(partie: Partie) {
    // localStorage.setItem('partie', JSON.stringify(partie));
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

  checkEndOfGame() {
    if (
      this.partie.membres[0].pv! <= 0 ||
      this.partie.navire?.robustesse! <= 0
    ) {
      this.partie.termine = true;
      this.router.navigate(['/ending']);
    }
    if (this.partie.ile!.nom == 'Ile4_NewWorld') {
      this.partie.termine = true;
      this.router.navigate(['/ending']);
    }
  }

  checkHpOrDeathMembre(membre: Membre, index: number) {
    if (membre.pv! <= 0) {
      if (!membre.pirate!.capitaine) {
        this.membreService.delete(membre.id).subscribe();
        this.partie.membres.splice(index, 1);
      }
      alert(membre.pirate?.nom + ' est mort !');
    } else if (membre.pv! > membre?.pirate?.pv!) {
      membre.pv = membre.pirate?.pv;
    }
    // else {
    //   this.membreService.update(membre).subscribe(() => {
    //     console.log('updating membre in db :>> ', membre);
    //   });
    // }
    this.update(this.partie).subscribe(() => {
      this.savePartieInStorage(this.partie);
    });
  }
}
