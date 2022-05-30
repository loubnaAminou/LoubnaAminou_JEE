package ma.enset.backend.mappers;

import ma.enset.backend.dtos.AccountOperationDTO;
import ma.enset.backend.dtos.CurrentAccountDTO;
import ma.enset.backend.dtos.CustomerDTO;
import ma.enset.backend.dtos.SavingAccountDTO;
import ma.enset.backend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setAccountIds(customer.getBankAccounts().stream().map(BankAccount::getId).collect(Collectors.toList()));
        return customerDTO;
    }

    public Customer fromCustomerDTO(CustomerDTO customerdto){
        Customer customer = new Customer();

        BeanUtils.copyProperties(customerdto, customer);

        return customer;
    }

    public SavingAccountDTO fromSavingAccount(SavingAccount savingAccount){
        SavingAccountDTO account = new SavingAccountDTO();
        BeanUtils.copyProperties(savingAccount, account);
        account.setType(savingAccount.getClass().getSimpleName());
        account.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
        return account;
    }

    public SavingAccount fromSavingAccountDTO(SavingAccountDTO savingAccount){
        SavingAccount account = new SavingAccount();
        BeanUtils.copyProperties(savingAccount, account);
        account.setCustomer(fromCustomerDTO(savingAccount.getCustomerDTO()));
        return account;
    }

    public CurrentAccountDTO fromCurrentAccount(CurrentAccount currentAccount){
        CurrentAccountDTO accountDTO = new CurrentAccountDTO();
        BeanUtils.copyProperties(currentAccount, accountDTO);
        accountDTO.setType(currentAccount.getClass().getSimpleName());
        accountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
        return accountDTO;
    }

    public CurrentAccount fromCurrentAccountDTO(CurrentAccountDTO currentAccount){
        CurrentAccount account = new CurrentAccount();
        BeanUtils.copyProperties(currentAccount, account);
        account.setCustomer(fromCustomerDTO(currentAccount.getCustomerDTO()));
        return account;
    }

    public AccountOperationDTO fromAccountOperation(AccountOperation operation){
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        BeanUtils.copyProperties(operation, accountOperationDTO);
        return accountOperationDTO;
    }

/**/
}
