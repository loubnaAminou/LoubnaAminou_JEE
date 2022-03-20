package ma.enset.demo.repositories;

import ma.enset.demo.entities.Medecin;
import ma.enset.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepo extends JpaRepository<Medecin, Long> {
    Medecin findByName(String name);
}
