import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CustomerService} from "../services/customer.service";
import {catchError, Observable, throwError} from "rxjs";
import {Customer} from "../model/customer";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers$! : Observable<Array<Customer>>;
  errorMessage : string | undefined;
  searchFormGroup : FormGroup | undefined;
  constructor(private service : CustomerService, private form : FormBuilder) {}

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

  handleDeletecustomer(customer : Customer) {
    let confirm_msg = "Are you sure you want to DELETE "+customer.name+ " ?"
    confirm(confirm_msg)
    this.service.deleteCustomer(customer.id).subscribe({
      next : data => this.handleSearchCustomers(),
      error : err => console.log(err)
    });
  }

  handleEditCustomer(customer : Customer) {

  }
}
