package ma.enset.demo.repositories;

import ma.enset.demo.entities.Consultation;
import ma.enset.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {
}
