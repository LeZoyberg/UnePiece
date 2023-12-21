import { Injectable } from '@angular/core';
import { Joueur } from './model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private utilisateur?: Joueur = undefined;

  constructor(private http: HttpClient, private router: Router) { }

  login(username: string, password: string) {    
    return this.http.post<Joueur>(environment.apiUrl + `/compte/connexion`, { "login": username, "password": password }).subscribe(resp => {
      this.utilisateur = resp;
      localStorage.setItem("user", JSON.stringify(this.utilisateur));

      this.router.navigate(["/accueil"]);
    });
  }

  logout() {
    this.utilisateur = undefined;
    localStorage.removeItem("user");
  }

  isLogged(): boolean {
    return this.getUtilisateur() != undefined;
  }

  getUtilisateur(): Joueur | undefined{
    if(this.utilisateur) {
      return this.utilisateur;
    } else {
      const user = localStorage.getItem("user")
      if(user) {
        this.utilisateur = JSON.parse(user);
        return this.utilisateur;
      }
    }
    return undefined;
  }

}
