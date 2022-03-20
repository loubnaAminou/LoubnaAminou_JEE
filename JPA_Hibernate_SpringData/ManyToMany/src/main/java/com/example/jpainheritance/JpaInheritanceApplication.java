package com.example.jpainheritance;

import com.example.jpainheritance.entities.Role;
import com.example.jpainheritance.entities.User;
import com.example.jpainheritance.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaInheritanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaInheritanceApplication.class, args);
    }
    // s'exé au démarrage

    @Bean
    CommandLineRunner start(UserService userService){
        /*return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            }
        }*/

        return args -> {

        Stream.of("lou", "louBna", "admin").forEach(u -> {
            User user = new User();
            user.setUsername(u);
            user.setPassword(u+"Password");
            userService.addUser(user);

        });

            Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
                Role role = new Role();
                role.setRoleName(r);
                userService.addRole(role);
            });

            userService.addRoletoUser("lou", "STUDENT");
            userService.addRoletoUser("louBna", "USER");
            userService.addRoletoUser("admin", "ADMIN");


            /*try{
                User guest = userService.authenticate("lou", "louXD");
                System.out.println(guest.getUserId());
                System.out.println(user.getUsername());
                System.out.print("=> Roles");
                guest.getRoles().forEach(System.out::println);
            }catch (Exception e){
                e.printStackTrace();
            }*/

        };
    }

}
