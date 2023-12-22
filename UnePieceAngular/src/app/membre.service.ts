import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Membre } from './model';

@Injectable({
  providedIn: 'root'
})
export class MembreService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Membre[]> {
    return this.http.get<Membre[]>(environment.apiUrl + "/membre");
  }

  findById(id?: number): Observable<Membre> {
    return this.http.get<Membre>(environment.apiUrl + "/membre/"+id);
  }

  create(membre: Membre): Observable<Membre> {
    return this.http.post<Membre>(environment.apiUrl + "/membre/"+membre.pirate?.id, membre);
  }

  update(membre: Membre): Observable<Membre> {
    return this.http.put<Membre>(environment.apiUrl + "/membre/"+membre.id, membre);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/membre/"+id);
  }


}
