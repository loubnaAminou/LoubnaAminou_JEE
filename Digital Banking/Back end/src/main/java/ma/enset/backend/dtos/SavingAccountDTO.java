package ma.enset.backend.dtos;

import lombok.Data;
import ma.enset.backend.enums.AccountStatus;
import java.util.Date;

@Data
public class SavingAccountDTO extends BankAccountDTO {
    private String id;
    private Date createdAt;
    private double balance;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
