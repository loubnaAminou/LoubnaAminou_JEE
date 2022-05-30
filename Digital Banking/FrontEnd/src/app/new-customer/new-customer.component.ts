import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerModel} from "../model/customer.model";
import {CustomerService} from "../services/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-customer',
  templateUrl: './new-customer.component.html',
  styleUrls: ['./new-customer.component.css']
})
export class NewCustomerComponent implements OnInit {

  newCustomerForm! : FormGroup;
  constructor(private formBuilder : FormBuilder, private customerService : CustomerService, private router : Router) { }

  ngOnInit(): void {
    this.newCustomerForm = this.formBuilder.group({
      name : this.formBuilder.control("Jane Doe", [Validators.required, Validators.minLength(4)]),
      email : this.formBuilder.control("Jane@Doe", [Validators.required, Validators.email])
    });
  }

  handleNewCustomer() {
    let customer : CustomerModel = this.newCustomerForm.value
      this.customerService.newCustomer(customer).subscribe({
        next : value => this.router.navigateByUrl("/customers"),
        error : err => console.log(err)
      });
  }
}
