import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AccountsService} from "../services/accounts.service";
import {Observable} from "rxjs";
import {AccountDetails} from "../model/account.model";
import {Router} from "@angular/router";
import {CustomerModel} from "../model/customer.model";
import {AuthenticationService} from "../services/authentication.service";

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  searchGroupForm! : FormGroup;
  operationGroupForm! : FormGroup;
  currentPage : number = 0;
  size : number = 5;
  accountObservable! : Observable<AccountDetails>;
  customer! : CustomerModel;
  accountId! : String;

  constructor(private builder : FormBuilder,
              private accountService : AccountsService,
              private authService : AuthenticationService,
              private router : Router) {
    this.customer = this.router.getCurrentNavigation()?.extras.state as CustomerModel;
    this.accountId = this.router.getCurrentNavigation()?.extras.state as String;

  }

  ngOnInit(): void {
    this.searchGroupForm = this.builder.group({
      accountId : this.builder.control(this.accountId)
    });

    this.operationGroupForm = this.builder.group({
      operationType : this.builder.control(null),
      amount : this.builder.control(0),
      description : this.builder.control(null),
      accountDest : this.builder.control(null)
    });

  }

  handleSearchAccounts() {
    let accountId = this.searchGroupForm.value.accountId;
    this.accountObservable = this.accountService.getAccount(accountId, this.currentPage, this.size);
  }

  goToPage(page : number) {
    this.currentPage = page;
    this.handleSearchAccounts();
  }

  handleOperations() {
    let accountId = this.searchGroupForm.value.accountId;
    let opertaionType = this.operationGroupForm.value.operationType;
    let amount = this.operationGroupForm.value.amount;
    let description = this.operationGroupForm.value.description;
    let dest = this.operationGroupForm.value.accountDest;
    if(opertaionType == 'DEBIT'){
      this.accountService.debit(accountId, amount,description).subscribe({
        next : value => {
          alert("Success Debit");
          this.handleSearchAccounts()
        } ,
        error : err => console.log(err)
      });
    }else if(opertaionType == 'CREDIT'){
      this.accountService.credit(accountId, amount,description).subscribe({
        next : value =>{
          alert("Success Credit")
          this.handleSearchAccounts()
        } ,
        error : err => console.log(err)
      });
    }else{
      this.accountService.transfer(accountId, dest,amount).subscribe({
        next : value =>{
          alert("Success Transfer")
          this.handleSearchAccounts();
        } ,
        error : err => console.log(err)
      });
    }
    this.operationGroupForm.reset();
  }

  isAdmin() {
    return this.authService.isAdmin();
  }
}
