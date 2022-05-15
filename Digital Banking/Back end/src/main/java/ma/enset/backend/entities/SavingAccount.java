package ma.enset.backend.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SA")
@Data
public class SavingAccount extends BankAccount{
    private double interestRate;
}
