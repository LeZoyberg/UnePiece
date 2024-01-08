import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Action } from './model';

@Injectable({
  providedIn: 'root'
})
export class ActionService {

  constructor(private http: HttpClient) { }

  findNRandomActions(N : number, partieId : number) : Observable<Action[]> {
    return this.http.get<Action[]>(environment.apiUrl + "/action/random/"+N+"/"+partieId);
  }
  
  findAllWithPartie(id : number): Observable<Action[]> {
    return this.http.get<Action[]>(environment.apiUrl + "/action/partie/"+id);
  }

  findAll(): Observable<Action[]> {
    return this.http.get<Action[]>(environment.apiUrl + "/action");
  }

  findById(id?: number): Observable<Action> {
    return this.http.get<Action>(environment.apiUrl + "/action/"+id);
  }

  create(action: Action): Observable<Action> {
    return this.http.post<Action>(environment.apiUrl + "/action", action);
  }

  update(action: Action): Observable<Action> {
    return this.http.put<Action>(environment.apiUrl + "/action/"+action.id, action);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/action/"+id);
  }
}
