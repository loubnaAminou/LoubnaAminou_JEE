import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CustomerModel} from "../model/customer.model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  customers : any;
  constructor(private http : HttpClient) { }

  public getCustomers():Observable<Array<CustomerModel>>{
    return this.http.get<Array<CustomerModel>>(environment.host+"/customers");
  }

  public searchCustomers(keyword : string):Observable<Array<CustomerModel>>{
    return this.http.get<Array<CustomerModel>>(environment.host+"/customers/search?keyword="+keyword);
  }

  public newCustomer(customer : CustomerModel):Observable<CustomerModel>{
    return this.http.post<CustomerModel>(environment.host+"/customers/", customer);
  }

  public deleteCustomer(id : number){
    return this.http.delete(environment.host+"/customers/"+id);
  }

  public updateCustomer(customer : CustomerModel):Observable<CustomerModel>{
    return this.http.put<CustomerModel>(environment.host+"/customers/", customer);
  }

}
