class Account{
  String accountId;
  double balance;
  List<AccountOperation> accountOperationDTOS;

  Account(this.accountId, this.balance, this.accountOperationDTOS);


}
class AccountOperation{
  int id;
  String operationDate;
  String amount;
  String type;
  String description;

  AccountOperation(
      this.id, this.operationDate, this.amount, this.type, this.description);
}