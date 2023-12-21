import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Pirate } from './model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PirateService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Pirate[]> {
    return this.http.get<Pirate[]>(environment.apiUrl + "/pirate");
  }

  findById(id?: number): Observable<Pirate> {
    return this.http.get<Pirate>(environment.apiUrl + "/pirate/"+id);
  }

  create(pirate: Pirate): Observable<Pirate> {
    return this.http.post<Pirate>(environment.apiUrl + "/pirate", pirate);
  }

  update(pirate: Pirate): Observable<Pirate> {
    return this.http.put<Pirate>(environment.apiUrl + "/pirate/"+pirate.id, pirate);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/pirate/"+id);
  }

}
