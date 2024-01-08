import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Joueur } from '../model';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {


  constructor(private authService: AuthService) { 
  }

  showUser() : string {
    return `${this.authService.getUtilisateur()?.login}`;
  }

  logout() {    
    if(confirm("Souhaitez-vous vraiment vous déconnecter ?")){
      alert("Vous vous êtes bien déconnecté");
      this.authService.logout();
    }
    else{
      alert("Vous êtes toujours connecté");
    }
  }

  isLogged(): boolean {
    return this.authService.isLogged();
 }
 
}
