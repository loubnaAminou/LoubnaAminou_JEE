import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {AccountsComponent} from "./accounts/accounts.component";
import {NewCustomerComponent} from "./new-customer/new-customer.component";
import {AccountProfileComponent} from "./account-profile/account-profile.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  {
    path : "customers", component: CustomersComponent
  },
  {
    path : "accounts", component: AccountsComponent
  },
  {
    path : "new-customer", component: NewCustomerComponent
  },
  {
    path : "account-profile", component: AccountProfileComponent
  },
  {
    path : "", component: LoginComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
