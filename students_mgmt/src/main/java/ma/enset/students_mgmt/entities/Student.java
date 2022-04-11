package ma.enset.students_mgmt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Student {
    @Id
    private String id;
    private String lastname;
    private String firstname;
    private String email;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private boolean in_rule;

}
