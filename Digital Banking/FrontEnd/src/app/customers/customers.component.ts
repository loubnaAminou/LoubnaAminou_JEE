import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CustomerService} from "../services/customer.service";
import {catchError, Observable, throwError} from "rxjs";
import {CustomerModel} from "../model/customer.model";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Route, Router} from "@angular/router";
import {AuthenticationService} from "../services/authentication.service";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers$! : Observable<Array<CustomerModel>>;
  errorMessage : string | undefined;
  searchFormGroup : FormGroup | undefined;
  constructor(private service : CustomerService,
              private form : FormBuilder,
              private router: Router,
              public authservice : AuthenticationService) {}

  ngOnInit(): void {
    this.searchFormGroup = this.form.group({
      keyword : this.form.control("")
    });
    this.customers$ = this.service.getCustomers().pipe(
      catchError(
        err => {
          this.errorMessage = err.message;
          return throwError(err);
        }
      )
    );
  }

  handleSearchCustomers() {
    let word = this.searchFormGroup?.value.keyword;
    this.customers$ = this.service.searchCustomers(word).pipe(
      catchError(
        err => {
          this.errorMessage = err.message;
          return throwError(err);
        }
      )
    );
  }

  handleDeletecustomer(customer : CustomerModel) {
    let confirm_msg = "Are you sure you want to DELETE "+customer.name+ " ?"
    confirm(confirm_msg)
    this.service.deleteCustomer(customer.id).subscribe({
      next : data => this.handleSearchCustomers(),
      error : err => console.log(err)
    });
  }

  handleEditCustomer(customer : CustomerModel) {

  }

  handleAccounts(customer: CustomerModel) {
    this.router.navigateByUrl("/account-profile", {state : customer});
  }

  isAdmin() {
    return this.authservice.isAdmin();
  }
}
