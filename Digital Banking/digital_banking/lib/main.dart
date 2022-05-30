import 'package:digital_banking/blocs/customer_bloc.dart';
import 'package:digital_banking/pages/accounts.dart';
import 'package:digital_banking/pages/customers.dart';
import 'package:digital_banking/pages/home.dart';
import 'package:digital_banking/repositories/customer_repo.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';


void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiBlocProvider(
      providers : [
        BlocProvider(create: (context) => CustomerBloc(CustomerState([], ""), CustomerRepository()))
      ],
      child: MaterialApp(
        theme: ThemeData(
          primarySwatch: Colors.blueGrey,
          primaryColor: Colors.blueGrey.shade800,
        ),
        routes: {
          "/" : (context) => HomePage(),
          "/customers" : (context) => Customers(),
          "/accounts" : (context) => Accounts()
        },
      ),
    );
  }
}
