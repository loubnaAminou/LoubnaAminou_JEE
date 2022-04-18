package ma.enset.students_mgmt;

import ma.enset.students_mgmt.entities.Gender;
import ma.enset.students_mgmt.entities.Student;
import ma.enset.students_mgmt.repositories.StudentRepo;
import ma.enset.students_mgmt.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class StudentsMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsMgmtApplication.class, args);
	}

	@Bean
	PasswordEncoder appPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	//@Bean
	CommandLineRunner saveUsers(SecurityService service){
		return args -> {
			service.newUser("user", "user", "user");
			service.newUser("admin", "admin", "admin");
			service.newRole("USER");
			service.newRole("ADMIN");
			service.addRoleToUser("user", "USER");
			service.addRoleToUser("admin", "USER");
			service.addRoleToUser("admin", "ADMIN");
		};

	}

	//@Bean
	CommandLineRunner saveStudents(StudentRepo repo){
		return args -> {
			Stream.of("Lou", "Ema", "Mery").forEach(name -> {
				repo.save(new Student(UUID.randomUUID().toString(), name+"Ami", name, "ami@"+name, new Date(), Gender.FEMALE, true));
			});

		};
	}
}
