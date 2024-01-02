import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Navire } from './model';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NavireService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Navire[]> {
    return this.http.get<Navire[]>(environment.apiUrl + "/navire");
  }

  findById(id?: number): Observable<Navire> {
    return this.http.get<Navire>(environment.apiUrl + "/navire/"+id);
  }

  create(navire: Navire): Observable<Navire> {
    return this.http.post<Navire>(environment.apiUrl + "/navire/"+navire.bateau?.id, navire);
  }

  update(navire: Navire): Observable<Navire> {
    return this.http.put<Navire>(environment.apiUrl + "/navire/"+navire.id, navire);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/navire/"+id);
  }
}
