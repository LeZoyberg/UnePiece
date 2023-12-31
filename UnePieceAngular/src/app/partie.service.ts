import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Membre, Partie } from './model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { MembreService } from './membre.service';
@Injectable({
  providedIn: 'root',
})
export class PartieService {
  partie!: Partie;

  constructor(private http: HttpClient, private router : Router, private membreService: MembreService) {}

  getPartie(): Partie | undefined {
    if (this.partie) {
      console.log('return this.partie');
      console.log('this.partie :>> ', this.partie);
      return this.partie;
    } else {
      const partieStorage = localStorage.getItem('partie');
      if (partieStorage) {
        console.log('return this.partie from localStorage');
        this.partie = JSON.parse(partieStorage);
        console.log('this.partie :>> ', this.partie);

        return this.partie;
      }
    }
    console.log('return undefined');

    return undefined;
  }

  savePartieInStorage(partie: Partie) {
    localStorage.setItem('partie', JSON.stringify(partie));
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
    console.log('[findByIdJoueur / partie.service.ts] id joueur:', id);
    console.log(
      '[findByIdJoueur / partie.service.ts] this.partie :>> ',
      this.partie
    );
    return this.http.get<Partie>(environment.apiUrl + '/partie/joueur/' + id);
  }

  findAllByIdJoueur(id : number): Observable<Partie[]> {
    return this.http.get<Partie[]>(environment.apiUrl + '/partie/historique/'+id);
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
        (this.partie.forceTotale as number) += (m.power as number);
        console.log('m :>> ', m);
    }
    console.log('this.partie.membres :>> ', this.partie.membres);
    console.log('this.partieService.getForceTotale() :>> ', this.partie.forceTotale);
  }

  checkEndOfGame() {
    if(this.partie.membres[0].pv! <= 0 || this.partie.navire?.robustesse! <= 0) {
      this.partie.termine = true;
      this.router.navigate(['/ending']);
    }
    if(this.partie.ile!.nom=="Ile4_NewWorld") {
      this.partie.termine = true;
      this.router.navigate(['/ending']);
    }
  }

  checkPvMembre(membre: Membre, index: number) {
    if(membre.pv! <= 0) {
      if(!membre.pirate!.capitaine){
        this.membreService.delete(membre.id).subscribe();
        this.partie.membres.splice(index,1);
      }
      this.update(this.partie).subscribe(() => {
        this.savePartieInStorage(this.partie);
      });  
      alert(membre.pirate?.nom + " est crevé");
    }
  }

}
