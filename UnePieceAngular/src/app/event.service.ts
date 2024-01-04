import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Evenement } from './model';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(environment.apiUrl + "/event");
  }

  findById(id?: number): Observable<Evenement> {
    return this.http.get<Evenement>(environment.apiUrl + "/event/"+id);
  }

  create(event: Evenement): Observable<Evenement> {
    return this.http.post<Evenement>(environment.apiUrl + "/event", event);
  }

  update(event: Evenement): Observable<Evenement> {
    return this.http.put<Evenement>(environment.apiUrl + "/event/"+event.id, event);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/event/"+id);
  }
}
