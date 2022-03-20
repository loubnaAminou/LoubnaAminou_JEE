package ma.enset.demo.repositories;

import ma.enset.demo.entities.Patient;
import ma.enset.demo.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepo extends JpaRepository<RendezVous, String> {
}
