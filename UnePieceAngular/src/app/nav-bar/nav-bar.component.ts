import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Joueur } from '../model';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  player!: Joueur;
  constructor(private authService: AuthService) { 
    this.player = authService.getUtilisateur() as Joueur;
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
