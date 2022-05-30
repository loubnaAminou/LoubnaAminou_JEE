package ma.enset.backend.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.backend.dtos.*;
import ma.enset.backend.entities.*;
import ma.enset.backend.enums.TypeOperation;
import ma.enset.backend.exceptions.AccountNotFoundException;
import ma.enset.backend.exceptions.BalanceNotSufficientException;
import ma.enset.backend.exceptions.CustomerNotFoundException;
import ma.enset.backend.mappers.BankAccountMapperImpl;
import ma.enset.backend.repositories.AccountOperationRepository;
import ma.enset.backend.repositories.BankAccountRepository;
import ma.enset.backend.repositories.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j // log information
public class BankAccountServiceImpl implements BankAccountService {
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;
    private BankAccountMapperImpl mapper;

    //Logger log = (Logger) LoggerFactory.getLogger(this.getClass().getName());
    // ----> log attribute ALREADY added by Lombok

    @Override
    public CustomerDTO saveCostumer(CustomerDTO customerdto) {
        log.info("Saving New Customer ...");
        Customer customer = mapper.fromCustomerDTO(customerdto);
        Customer saved = customerRepository.save(customer);
        return mapper.fromCustomer(saved);
    }

    @Override
    public void deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerDTO updateCostumer(CustomerDTO customerdto) {
            log.info("Updating a Customer ...");
            Customer customer = mapper.fromCustomerDTO(customerdto);
            Customer saved = customerRepository.save(customer);
            return mapper.fromCustomer(saved);
    }

    @Override
    public CurrentAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer == null) throw new CustomerNotFoundException("Customer NOT FOUND !!!");

        CurrentAccount current = new CurrentAccount();
        current.setId(UUID.randomUUID().toString());
        current.setCreatedAt(new Date());
        current.setBalance(initialBalance);
        current.setOverDraft(overDraft);
        current.setCustomer(customer);

        CurrentAccount saved = bankAccountRepository.save(current);
        return mapper.fromCurrentAccount(saved);
    }

    @Override
    public SavingAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer == null) throw new CustomerNotFoundException("Customer NOT FOUND !!!");

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setId(UUID.randomUUID().toString());
        savingAccount.setCreatedAt(new Date());
        savingAccount.setBalance(initialBalance);
        savingAccount.setInterestRate(interestRate);
        savingAccount.setCustomer(customer);

        SavingAccount saved = bankAccountRepository.save(savingAccount);
        return mapper.fromSavingAccount(saved);
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        List<Customer> all = customerRepository.findAll();
        List<CustomerDTO> dtos = all.stream()
                .map(customer -> mapper.fromCustomer(customer))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public BankAccountDTO getBankAccount(String id) throws AccountNotFoundException {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account NOT FOUND !!!"));

        if(account instanceof SavingAccount){
            SavingAccount savingAccount = (SavingAccount) account;
            return mapper.fromSavingAccount(savingAccount);
        }
        else{
            CurrentAccount currentAccount = (CurrentAccount) account;
            return mapper.fromCurrentAccount(currentAccount);
        }

    }

    @Override
    public void debit(String accountId, double amount, String description) throws AccountNotFoundException, BalanceNotSufficientException {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account NOT FOUND !!!"));

        if(bankAccount.getBalance() < amount)
            throw new BalanceNotSufficientException("Balance Not Sufficient !!!");

        AccountOperation operation = new AccountOperation();
        operation.setType(TypeOperation.DEBIT);
        operation.setOperationDate(new Date());
        operation.setAmount(amount);
        operation.setDescription(description);
        operation.setBankAccount(bankAccount);

        accountOperationRepository.save(operation);
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void credit(String accountId, double amount, String description) throws AccountNotFoundException, BalanceNotSufficientException {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account NOT FOUND !!!"));
        if(bankAccount.getBalance() < amount)
            throw new BalanceNotSufficientException("Balance Not Sufficient !!!");

        AccountOperation operation = new AccountOperation();
        operation.setType(TypeOperation.CREDIT);
        operation.setOperationDate(new Date());
        operation.setAmount(amount);
        operation.setDescription(description);
        operation.setBankAccount(bankAccount);

        accountOperationRepository.save(operation);
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void transfer(String sourceId, String destinationId, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
        debit(sourceId, amount, "Transfer To "+destinationId);
        credit(destinationId, amount, "Transfer From "+sourceId);
    }

    @Override
    public List<BankAccountDTO> bankAccountsList() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        return bankAccounts.stream().map(bankAccount -> {
            if(bankAccount instanceof SavingAccount){
                SavingAccount savingAccount = (SavingAccount) bankAccount;
                return mapper.fromSavingAccount(savingAccount);
            }else {
                CurrentAccount currentAccount = (CurrentAccount) bankAccount;
                return mapper.fromCurrentAccount(currentAccount);
            }
        }).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("NOT FOUND !!!"));
        return mapper.fromCustomer(customer);
    }

    @Override
    public List<AccountOperationDTO> accountHistory(String accountId){
        List<AccountOperation> accountOperations = accountOperationRepository.findAll();
        return accountOperations.stream().map(account -> mapper.fromAccountOperation(account)).collect(Collectors.toList());
    }

    @Override
    public AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws AccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElse(null);
        if (bankAccount == null) throw new AccountNotFoundException("not found");
        Page<AccountOperation> accountOperations = accountOperationRepository.findByBankAccountIdOrderByOperationDateDesc(accountId, PageRequest.of(page, size));
        AccountHistoryDTO historyDTO = new AccountHistoryDTO();
        List<AccountOperationDTO> accountOperationsDTO = accountOperations.getContent().stream().map(operation -> mapper.fromAccountOperation(operation)).collect(Collectors.toList());
        historyDTO.setAccountId(bankAccount.getId());
        historyDTO.setBalance(bankAccount.getBalance());
        historyDTO.setSize(size);
        historyDTO.setPageSize(page);
        historyDTO.setTotalPages(accountOperations.getTotalPages());
        historyDTO.setAccountOperationDTOS(accountOperationsDTO);
        return historyDTO;
    }

    @Override
    public List<CustomerDTO> searchCustomers(String keyword) {
        List<Customer> search = customerRepository.searchCustomers(keyword);
        return search.stream().map(customer -> mapper.fromCustomer(customer)).collect(Collectors.toList());
    }
}
