import 'package:flutter/material.dart';

import '../models/customer.dart';

class Accounts extends StatelessWidget {
  const Accounts({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    Customer customer = ModalRoute.of(context)!.settings.arguments as Customer;
    return Scaffold(
      appBar: AppBar(title :Text("Accounts of ${customer.name}"),centerTitle: true,
      ),
      body: Center(
        child: Column(
          children: [
            Text("Accounts"),
            Expanded(
              child: ListView.builder(
                itemCount: customer.accountIds.length,
                itemBuilder: (context, index){
                  return ListTile(
                    title: Text(customer.accountIds[index])
                  );
                },
              ),
            )
          ],
        ),


      ),
    );
  }
}
