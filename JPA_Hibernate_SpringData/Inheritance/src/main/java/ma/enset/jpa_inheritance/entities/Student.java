package ma.enset.jpa_inheritance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Stud")
@Data @NoArgsConstructor @AllArgsConstructor
public class Student extends Person {
    private Double score;
}
