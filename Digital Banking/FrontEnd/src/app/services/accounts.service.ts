import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {AccountDetails} from "../model/account.model";

@Injectable({
  providedIn: 'root'
})
export class AccountsService {

  constructor(private http : HttpClient) { }

  public getAccount(accountId : string, page : number, size : number):Observable<AccountDetails>{
    return this.http.get<AccountDetails>(environment.host+"/accounts/"+accountId+"/pageOperations?page="+page+"&size="+size);
  }

  public debit(accountId: string, amount: number, description : string){
    let body = {accountId, amount, description};
    return this.http.post(environment.host+"/accounts/debit", body);
  }

  public credit(accountId: string, amount: number, description : string){
    let body = {accountId, amount, description};
    return this.http.post(environment.host+"/accounts/credit", body);
  }

  public transfer(accountSource: string, accountDestination: string, amount: number){
    let body = {accountSource, accountDestination, amount};
    return this.http.post(environment.host+"/accounts/transfer", body);
  }

}
