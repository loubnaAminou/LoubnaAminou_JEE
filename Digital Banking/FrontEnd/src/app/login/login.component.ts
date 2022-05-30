import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../services/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router : Router, private authService : AuthenticationService) { }

  ngOnInit(): void {


  }

  onLogin(data : any) {

    this.authService.login(data.username, data.password);
    this.authService.saveOnLocalStorage();
    if(this.authService.isAuthenticated){
      this.router.navigateByUrl("/customers");
    }
  }


}
