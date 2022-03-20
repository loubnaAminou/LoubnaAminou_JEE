package ma.enset.jpa_inheritance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Prof")
@Data @NoArgsConstructor @AllArgsConstructor
public class Professor extends Person {
    private String subject;
}
