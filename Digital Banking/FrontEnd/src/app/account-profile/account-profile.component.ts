import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CustomerModel} from "../model/customer.model";

@Component({
  selector: 'app-account-profile',
  templateUrl: './account-profile.component.html',
  styleUrls: ['./account-profile.component.css']
})
export class AccountProfileComponent implements OnInit {
  customer! : CustomerModel


  constructor(private router : Router) {
    this.customer = this.router.getCurrentNavigation()?.extras.state as CustomerModel;
  }

  ngOnInit(): void {
    console.log("--------CUSTOMER "+this.customer);

  }

  handleAccounts(accountId: String) {
    this.router.navigateByUrl("/accounts", {state : accountId});
  }
}
