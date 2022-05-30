import 'package:digital_banking/blocs/customer_bloc.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class Customers extends StatelessWidget {
  const Customers({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Customers"), centerTitle: true,
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Text("List of Customers"),
              BlocBuilder<CustomerBloc, CustomerState>(
                  builder : (context, state){
                    print("state ${state.customers}");
                return Expanded(
                  child: ListView.builder(
                    itemCount: state.customers.length,
                    itemBuilder: (context, index){
                      return ListTile(
                        title: Text(state.customers[index].email),
                        leading: CircleAvatar(child: Text(state.customers[index].name.substring(0,2).toUpperCase())),
                      onTap: (){
                      Navigator.pushNamed(context, "/accounts", arguments: state.customers[index]);//, arguments: accountID
                    },
                  );
              },
              ),
              );
              }),

            ],
          ),
        )

    );
  }
}
