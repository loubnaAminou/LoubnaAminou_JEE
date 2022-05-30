package ma.enset.backend.services;

import ma.enset.backend.dtos.*;
import ma.enset.backend.exceptions.AccountNotFoundException;
import ma.enset.backend.exceptions.BalanceNotSufficientException;
import ma.enset.backend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCostumer(CustomerDTO customer);

    void deleteCustomer(Long customerId);

    CustomerDTO updateCostumer(CustomerDTO customerdto);

    CurrentAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;

    SavingAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;

    List<CustomerDTO> listCustomers();

    BankAccountDTO getBankAccount(String id) throws AccountNotFoundException;

    void debit(String accountId, double amount, String description) throws AccountNotFoundException, BalanceNotSufficientException;

    void credit(String accountId, double amount, String description) throws AccountNotFoundException, BalanceNotSufficientException;

    void transfer(String sourceId, String destinationId, double amount) throws AccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountsList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws AccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
