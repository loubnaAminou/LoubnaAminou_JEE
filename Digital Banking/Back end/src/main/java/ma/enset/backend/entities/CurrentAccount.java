package ma.enset.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "CA")
@Data
public class CurrentAccount extends BankAccount{
    private double overDraft; // découvert
}
