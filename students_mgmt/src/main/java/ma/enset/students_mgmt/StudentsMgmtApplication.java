package ma.enset.students_mgmt;

import ma.enset.students_mgmt.entities.Gender;
import ma.enset.students_mgmt.entities.Student;
import ma.enset.students_mgmt.repositories.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class StudentsMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsMgmtApplication.class, args);
	}

	@Bean
	CommandLineRunner saveStudents(StudentRepo repo){
		return args -> {
			Stream.of("Lou", "Ema", "Mery").forEach(name -> {
				repo.save(new Student(UUID.randomUUID().toString(), name+"Ami", name, "ami@"+name, new Date(), Gender.FEMALE, true));
			});

		};
	}
}
