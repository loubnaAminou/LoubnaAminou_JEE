package ma.enset.jpa_inheritance;

import ma.enset.jpa_inheritance.entities.Person;
import ma.enset.jpa_inheritance.entities.Professor;
import ma.enset.jpa_inheritance.entities.Student;
import ma.enset.jpa_inheritance.repositories.PersonRepo;
import org.apache.tomcat.util.net.jsse.PEMFile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JpaInheritanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaInheritanceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PersonRepo personRepo){
        return args -> {
            /********************      Student     ********************/
            Student student = new Student();
            student.setName("Loubna");
            student.setBirthDate(new Date());
            student.setScore(17.5);

            personRepo.save(student);

            /*********************    Professor    *************************/
            Professor prof = new Professor();
            prof.setBirthDate(new Date());
            prof.setName("Mohamed Amali");
            prof.setSubject("Technology science");

            personRepo.save(prof);

        };
    }

}
