package ma.enset.jpa_inheritance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", length = 4)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Person {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private Date birthDate;

}
