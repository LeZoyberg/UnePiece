import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { AccueilComponent } from './accueil/accueil.component';
import { StartComponent } from './start/start.component';
import { IleComponent } from './ile/ile.component';
import { TrajetComponent } from './trajet/trajet.component';

const routes: Routes = [
  {path: "accueil", component: AccueilComponent},
  {path: "inscription", component: InscriptionComponent},
  {path: "login", component: LoginComponent},
  {path: "start", component: StartComponent},
  {path: "ile", component: IleComponent},
  {path: "trajet", component: TrajetComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
