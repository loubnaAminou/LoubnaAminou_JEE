package ma.enset.backend.web;

import lombok.AllArgsConstructor;
import ma.enset.backend.dtos.AccountHistoryDTO;
import ma.enset.backend.dtos.AccountOperationDTO;
import ma.enset.backend.dtos.BankAccountDTO;
import ma.enset.backend.entities.AccountOperation;
import ma.enset.backend.exceptions.AccountNotFoundException;
import ma.enset.backend.services.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
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

}
