package com.example.spring_web;

import com.example.spring_web.entities.Patient;
import com.example.spring_web.repositories.PatientRepo;
import com.example.spring_web.security.services.ServiceSecurity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepo repo){
        return args -> {
            repo.save(new Patient(null, "Lou", new Date(), false, 12));
            Stream.of("MedAmine", "Imannou", "Mery").forEach(name -> {
                repo.save(new Patient(null, name, new Date(), Math.random()>0.5?false : true, Math.random()*20));
            });
        };
    }


    @Bean
    PasswordEncoder appPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner saveUsers(ServiceSecurity service){
        return args -> {
            service.saveNewUser("user", "user", "user");
            service.saveNewUser("admin", "admin", "admin");
            service.saveNewRole("USER", "default user");
            service.saveNewRole("ADMIN", "admin controller");
            service.addRoleToUser("user", "USER");
            service.addRoleToUser("admin", "USER");
            service.addRoleToUser("admin", "ADMIN");
        };
    }

}
