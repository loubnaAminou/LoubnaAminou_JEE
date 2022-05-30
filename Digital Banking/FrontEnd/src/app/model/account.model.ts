//generate model from json : https://app.quicktype.io/?l=ts
export interface AccountDetails{
  accountId : string;
  balance : number;
  currentPage : number;
  totalPages : number;
  size : number;
  accountOperationDTOS : AccountOperation[]
}

export interface AccountOperation{
  id : number;
  operationDate : Date;
  amount : string;
  type : string;
  description : string;

}
