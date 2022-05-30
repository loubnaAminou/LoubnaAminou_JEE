import 'dart:async';

import 'package:bloc/bloc.dart';
import 'package:digital_banking/models/customer.dart';
import 'package:digital_banking/repositories/customer_repo.dart';
import 'package:meta/meta.dart';

part 'customer_event.dart';
part 'customer_state.dart';

class CustomerBloc extends Bloc<CustomerEvent, CustomerState> {
  CustomerRepository customerRepository;
  CustomerBloc(CustomerState state, this.customerRepository) : super(state) {
    on<CustomerEvent>((event, emit) async{
      if (event is AllCustomersEvent) {
        List<Customer> customers = await customerRepository.getCustomers();
        emit(CustomerState(customers, ""));
      }
    });
  }
}
