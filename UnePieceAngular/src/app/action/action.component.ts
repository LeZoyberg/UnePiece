import { Component } from '@angular/core';
import { Action, Partie } from '../model';
import { IleService } from '../ile.service';
import { PartieService } from '../partie.service';

@Component({
  selector: 'action',
  templateUrl: './action.component.html',
  styleUrls: ['./action.component.css']
})
export class ActionComponent {
action: Action = new Action;
partie: Partie = new Partie;


  constructor(){
    //private ileService: IleService,
    //private partieService: PartieService,
  }


}
