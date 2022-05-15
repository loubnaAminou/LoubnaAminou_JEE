package ma.enset.backend.entities;

import lombok.Data;
import ma.enset.backend.enums.TypeOperation;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeOperation type;
    private double amount;
    private Date operationDate;
    private String description;
    @ManyToOne
    private BankAccount bankAccount;
}
