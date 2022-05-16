package ma.enset.backend.dtos;

import lombok.Data;
import ma.enset.backend.enums.TypeOperation;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeOperation type;
    private double amount;
    private Date operationDate;
    private String description;

}
