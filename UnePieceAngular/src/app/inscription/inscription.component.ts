import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { confirmEqualValidator } from '../confirm-equal-validator.validator';

@Component({
  selector: 'inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  inscriptionForm!: FormGroup;

  usernameCtrl!: FormControl;
  passwordCtrl!: FormControl;
  //validatePasswordCtrl!: FormControl;

  constructor(private authService: AuthService, private formBuilder: FormBuilder, private router: Router) {

  }

  ngOnInit(): void {
    this.usernameCtrl = this.formBuilder.control("", Validators.required);
    this.passwordCtrl = this.formBuilder.control("", [Validators.required, Validators.minLength(5)]);
    //this.validatePasswordCtrl = this.formBuilder.control("", [Validators.required]);

    this.inscriptionForm = this.formBuilder.group({
      username: this.usernameCtrl,
      password: this.passwordCtrl,
      //validatePassword: this.validatePasswordCtrl
      }
      /*,
      {
        validator: [confirmEqualValidator('password', 'validatePassword')]
      }*/
    );
  }

  inscription() {
    this.authService.inscription(this.usernameCtrl.value, this.passwordCtrl.value);
  }

}
