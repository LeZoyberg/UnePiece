import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;

  usernameCtrl!: FormControl;
  passwordCtrl!: FormControl;

  
  constructor(private authService: AuthService, private formBuilder: FormBuilder) {

  }

  ngOnInit(): void {
    this.usernameCtrl = this.formBuilder.control("", Validators.required);
    this.passwordCtrl = this.formBuilder.control("", [Validators.required, Validators.minLength(5)]);

    this.loginForm = this.formBuilder.group({
      username: this.usernameCtrl,
      password: this.passwordCtrl
    });
  }
  
  connexion() {
    this.authService.login(this.usernameCtrl.value, this.passwordCtrl.value);
  }

}
