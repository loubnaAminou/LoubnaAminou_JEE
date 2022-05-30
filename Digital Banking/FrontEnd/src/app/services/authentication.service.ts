import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private users = [
    {username : "user", password : "password", roles : ['CUSTOMER']},
    {username : "user2", password : "password", roles : ['CUSTOMER']},
    {username : "admin", password : "admin", roles : ['ADMIN', 'CUSTOMER']},
  ];
  public isAuthenticated : boolean = false;
  public userAuthenticated : any;
  private token: any;

  constructor() { }

  public login(username:string, password:string){
    let user;
    this.users.forEach(u =>{
      if(username == u.username && password == u.password){
        user = u;
        console.log("------------"+user.roles);
        this.token = btoa(JSON.stringify(user));
      }
    });
    if(user){
      this.isAuthenticated = true;
      this.userAuthenticated = user;
    }else{
      this.isAuthenticated = false;
      this.userAuthenticated = undefined;
    }

  }

  public isAdmin() {
    if(this.isAuthenticated){
      if(this.userAuthenticated.roles.indexOf('ADMIN') > -1){
        return true;
      }
    }
    return false;
  }

  public saveOnLocalStorage(){
    if(this.isAuthenticated){
      localStorage.setItem("authToken", this.token);
    }
  }

  /*public loadFromLocalStorage(){
    let token = localStorage.getItem('authToken');
    if(token){
      let user = JSON.parse(atob(token));
      this.userAuthenticated = user;
    }
  }*/

  public removeFromLocalStorage(){
    localStorage.removeItem('authToken');
    this.userAuthenticated = undefined;
    this.token = undefined;
    this.isAuthenticated = false;
  }

}
