import { Injectable } from '@angular/core';
import { Ile } from './model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IleService {

  ile: Ile = new Ile();

  constructor(private http: HttpClient) {

  }

  findAll(): Observable<Ile[]> {
    return this.http.get<Ile[]>(`${environment.apiUrl}/ile`);
  }

  findById(id?:number): Observable<Ile> {
    return this.http.get<Ile>(`${environment.apiUrl}/ile/${id}`);
  }

  create(ile: Ile): Observable<Ile> {
    return this.http.post<Ile>(`${environment.apiUrl}/ile`, ile);
  }

  update(ile: Ile): Observable<Ile> {
    return this.http.put<Ile>(`${environment.apiUrl}/partie/${ile.id}`, ile);
  }

  delete(id?:number): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/partie/${id}`);
  }
}
