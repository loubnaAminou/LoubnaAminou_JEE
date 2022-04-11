package ma.enset.students_mgmt.repositories;

import ma.enset.students_mgmt.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, String> {
    Page<Student> findStudentByLastnameContains(String name, Pageable pageable);

}
