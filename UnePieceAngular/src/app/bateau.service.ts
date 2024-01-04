import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Bateau } from './model';

@Injectable({
  providedIn: 'root'
})
export class BateauService {

  constructor(private http: HttpClient) { }

  getRandomBateaux(idIle: number) : Observable<Bateau[]> {
    return this.http.get<Bateau[]>(environment.apiUrl + "/bateau/random/"+idIle);
  }

  findAll(): Observable<Bateau[]> {
    return this.http.get<Bateau[]>(environment.apiUrl + "/bateau");
  }

  findById(id?: number): Observable<Bateau> {
    return this.http.get<Bateau>(environment.apiUrl + "/bateau/"+id);
  }

  create(bateau: Bateau): Observable<Bateau> {
    return this.http.post<Bateau>(environment.apiUrl + "/bateau", bateau);
  }

  update(bateau: Bateau): Observable<Bateau> {
    return this.http.put<Bateau>(environment.apiUrl + "/bateau/"+bateau.id, bateau);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/bateau/"+id);
  }
}
