package ma.enset.students_mgmt.security.repositories;

import ma.enset.students_mgmt.security.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserApp, Long> {
    UserApp findByUsername(String username);
}
