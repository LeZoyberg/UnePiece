import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent {

  inscriptionForm!: FormGroup;

  usernameCtrl!: FormControl;
  passwordCtrl!: FormControl;
}
