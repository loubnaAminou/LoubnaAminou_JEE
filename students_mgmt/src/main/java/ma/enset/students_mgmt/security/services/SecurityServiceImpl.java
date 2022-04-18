package ma.enset.students_mgmt.security.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.students_mgmt.security.entities.RoleApp;
import ma.enset.students_mgmt.security.entities.UserApp;
import ma.enset.students_mgmt.security.repositories.RoleRepo;
import ma.enset.students_mgmt.security.repositories.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserApp newUser(String username, String password, String confirm) {
        if (!password.equals(confirm)) throw new RuntimeException("NOT MATCH");
        String hashed = passwordEncoder.encode(password);
        UserApp user = new UserApp();
        user.setUsername(username);
        user.setPassword(hashed);
        user.setEnabled(true);
        UserApp saved = userRepo.save(user);
        return saved;
    }

    @Override
    public RoleApp newRole(String name) {
        RoleApp roleApp = roleRepo.findByName(name);
        if (roleApp == null){
            RoleApp role = new RoleApp();
            role.setName(name);
            RoleApp saved = roleRepo.save(role);
            return saved;
        }else throw new RuntimeException("already exists");

    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        UserApp user = userRepo.findByUsername(username);
        RoleApp role = roleRepo.findByName(rolename);

        user.getRoles().add(role);
    }

    @Override
    public UserApp loadByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
