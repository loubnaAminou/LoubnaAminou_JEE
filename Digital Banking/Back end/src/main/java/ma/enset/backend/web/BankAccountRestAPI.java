package ma.enset.backend.web;

import lombok.AllArgsConstructor;
import ma.enset.backend.dtos.*;
import ma.enset.backend.entities.AccountOperation;
import ma.enset.backend.exceptions.AccountNotFoundException;
import ma.enset.backend.exceptions.BalanceNotSufficientException;
import ma.enset.backend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class BankAccountRestAPI {
    private BankAccountService service;

    @GetMapping("/accounts")
    public List<BankAccountDTO> getBankAccounts(String accountId) {
        return service.bankAccountsList();
    }

    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws AccountNotFoundException {
        return service.getBankAccount(accountId);
    }

    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return service.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) throws AccountNotFoundException {
        return service.getAccountHistory(accountId, page, size);
    }/**/

    @PostMapping("/accounts/debit")
    public DebitDTO debit(@RequestBody DebitDTO debitDTO) throws AccountNotFoundException, BalanceNotSufficientException {
        this.service.debit(debitDTO.getAccountId(), debitDTO.getAmount(), debitDTO.getDescription());
        return debitDTO;
    }

    @PostMapping("/accounts/credit")
    public CreditDTO credit(@RequestBody CreditDTO creditDTO) throws AccountNotFoundException, BalanceNotSufficientException {
        this.service.credit(creditDTO.getAccountId(), creditDTO.getAmount(), creditDTO.getDescription());
        return creditDTO;
    }

    @PostMapping("/accounts/transfer")
    public void transfer(@RequestBody TransferDTO transferDTO) throws AccountNotFoundException, BalanceNotSufficientException {
        this.service.transfer(transferDTO.getAccountSource(), transferDTO.getAccountDestination(), transferDTO.getAmount());
    }


}
