import 'dart:convert';

import 'package:digital_banking/models/customer.dart';
import 'package:http/http.dart' as http;

class CustomerRepository{

  Future<List<Customer>> getCustomers() async{
    List<Customer> c = [];
    List<dynamic> customers = [];Customer cust;
    String uri = "http://192.168.1.108:8085/customers";
    var response = await http.get(Uri.parse(uri));

      customers = json.decode(response.body);


    for(int i=0; i<customers.length; i++){
      List<dynamic> ids = customers[i]["accountIds"];
      List<String> accountIds = ids.cast<String>();
      cust = Customer(customers[i]["id"], customers[i]["name"], customers[i]["email"], accountIds );
      c.add(cust);
    }
    print(c);

    return c;
  }
}