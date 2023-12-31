import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccueilComponent } from './accueil/accueil.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { StartComponent } from './start/start.component';
import { IleComponent } from './ile/ile.component';
import { TrajetComponent } from './trajet/trajet.component';
import { StatEquipageComponent } from './stat-equipage/stat-equipage.component';
import { ActionComponent } from './action/action.component';
import { EndingComponent } from './ending/ending.component';


@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    InscriptionComponent,
    LoginComponent,
    NavBarComponent,
    StartComponent,
    IleComponent,
    TrajetComponent,
    StatEquipageComponent,
    ActionComponent,
    EndingComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
