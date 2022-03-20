package ma.enset.demo.repositories;

import ma.enset.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
}
