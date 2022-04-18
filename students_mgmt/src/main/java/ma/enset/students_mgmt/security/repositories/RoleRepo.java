package ma.enset.students_mgmt.security.repositories;

import ma.enset.students_mgmt.security.entities.RoleApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleApp, Long> {
    RoleApp findByName(String name);
}
