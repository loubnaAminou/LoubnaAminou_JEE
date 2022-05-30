import 'package:digital_banking/blocs/customer_bloc.dart';
import 'package:digital_banking/repositories/customer_repo.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';


class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Digital Banking"),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            Text("Welcome To the Digital Banking Application",
                textAlign: TextAlign.center,
                style : TextStyle(
                    fontSize: 28,
                    color: Colors.teal, //font color
                    backgroundColor: Colors.black12, //background color
                    letterSpacing: 5, //letter spacing
                    fontStyle: FontStyle.italic,

                ),
            ),
            ElevatedButton(
              onPressed: (){
                context.read<CustomerBloc>().add(AllCustomersEvent());
                Navigator.pushNamed(context, "/customers");
            },
              child: Text("Go to Customers"),
                style: ElevatedButton.styleFrom(
                    primary: Colors.blueGrey)
            )
          ],
        ),
      ),
    );
  }
}
