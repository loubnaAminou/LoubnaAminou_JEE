package ma.enset.jpa_inheritance.repositories;

import ma.enset.jpa_inheritance.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
