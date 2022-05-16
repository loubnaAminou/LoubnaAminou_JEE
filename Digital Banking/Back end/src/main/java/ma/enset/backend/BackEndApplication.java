package ma.enset.backend;

import ma.enset.backend.dtos.BankAccountDTO;
import ma.enset.backend.dtos.CurrentAccountDTO;
import ma.enset.backend.dtos.CustomerDTO;
import ma.enset.backend.dtos.SavingAccountDTO;
import ma.enset.backend.entities.*;
import ma.enset.backend.enums.AccountStatus;
import ma.enset.backend.enums.TypeOperation;
import ma.enset.backend.exceptions.AccountNotFoundException;
import ma.enset.backend.exceptions.BalanceNotSufficientException;
import ma.enset.backend.exceptions.CustomerNotFoundException;
import ma.enset.backend.repositories.AccountOperationRepository;
import ma.enset.backend.repositories.BankAccountRepository;
import ma.enset.backend.repositories.CustomerRepository;
import ma.enset.backend.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }

    //@Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository,
                            CustomerRepository customerRepository,
                            AccountOperationRepository operationRepository){
        return args -> {
            Stream.of("Jamaa", "Yamna", "Aicha").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(cust -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setCustomer(cust);
                currentAccount.setOverDraft(9000);
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCreatedAt(new Date());
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setCustomer(cust);
                savingAccount.setInterestRate(4.5);
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCreatedAt(new Date());
                bankAccountRepository.save(savingAccount);
            });

            bankAccountRepository.findAll().forEach(bankAccount -> {
                for(int i=0; i < 10; i++){
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setBankAccount(bankAccount);
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random()*12000);
                    accountOperation.setType((Math.random() > 0.5 ? TypeOperation.DEBIT : TypeOperation.CREDIT));
                    operationRepository.save(accountOperation);
                }
            });

        };
        }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService service){
        return args -> {
            Stream.of("Imane", "Mery", "Latifa", "Ahmed").forEach(name -> {
                CustomerDTO customer = new CustomerDTO();
                customer.setName(name);
                customer.setEmail("name"+"@gmail.com");
                service.saveCostumer(customer);
            });

            service.listCustomers().forEach(customer -> {
                try {

                    // Create for each client
                service.saveCurrentBankAccount(Math.random() * 9000, 9000, customer.getId());
                service.saveSavingBankAccount(Math.random() * 12000, 5.5, customer.getId());
                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });

            List<BankAccountDTO> bankAccounts = service.bankAccountsList();
            for (BankAccountDTO account : bankAccounts) {
                String accountId;
                if(account instanceof SavingAccountDTO){
                    accountId = ((SavingAccountDTO) account).getId();
                }else{
                    accountId = ((CurrentAccountDTO) account).getId();
                }
                service.credit(accountId, 100 + Math.random() * 100, "Credit");
                service.debit(accountId, 10 + Math.random() * 90, "Debit");

            }
            };
        }
}

