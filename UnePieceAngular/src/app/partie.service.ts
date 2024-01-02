import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Partie } from './model';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PartieService {

  partie: Partie = new Partie();

  constructor(private http: HttpClient) {
   }

   getPartie() : Partie {
    return this.partie
  }

  setPartie(partie:Partie) {
    this.partie = partie;
  }

  findAll(): Observable<Partie[]> {
    return this.http.get<Partie[]>(environment.apiUrl + "/partie");
  }

  findById(id?: number): Observable<Partie> {
    return this.http.get<Partie>(environment.apiUrl + "/partie/"+id);
  }

  create(partie: Partie): Observable<Partie> {
    return this.http.post<Partie>(environment.apiUrl + "/partie", partie);
  }

  update(partie: Partie): Observable<Partie> {
    return this.http.put<Partie>(environment.apiUrl + "/partie/"+partie.id, partie);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/partie/"+id);
  }

  findByIdJoueur(id?: number) : Observable<Partie> {
    return this.http.get<Partie>(environment.apiUrl + "/partie/joueur/"+id);
  }

  findByIdJoueurWithMembres(id?: number) : Observable<Partie> {
    return this.http.get<Partie>(environment.apiUrl + "/partie/joueur/"+id+"/membres");
  }

}
