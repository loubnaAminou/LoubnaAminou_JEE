package com.example.spring_web.security.services;

import com.example.spring_web.security.entities.AppRole;
import com.example.spring_web.security.entities.AppUser;
import com.example.spring_web.security.repositories.AppRoleRepo;
import com.example.spring_web.security.repositories.AppUserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j // lombok : login
@AllArgsConstructor
@Transactional // many to many relationship : link between two records user & role
public class SecurityServiceImpl implements ServiceSecurity {
    private AppUserRepo userRepo;
    private AppRoleRepo roleRepo;
    private PasswordEncoder appPasswordEncoder;
    @Override
    public AppUser saveNewUser(String username, String password, String confirmPwd) {
        if (!password.equals(confirmPwd)) throw new RuntimeException("NOT MATCH !!");
        String hashedPwd = appPasswordEncoder.encode(password);
        AppUser user = new AppUser();
        user.setUserId(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setPassword(hashedPwd);
        user.setActive(true);
        AppUser saved = userRepo.save(user);
        return saved;
    }

    @Override
    public AppRole saveNewRole(String rolename, String desc) {
        AppRole role = roleRepo.findByRoleName(rolename);
        if(role != null) throw new RuntimeException("ROLE "+rolename+" ALREADY EXISTS !");
        else {
            role = new AppRole();
            role.setRoleName(rolename);
            role.setDescription(desc);
        }
        AppRole saved = roleRepo.save(role);
        return saved;
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser user = userRepo.findByUsername(username);
        if(user == null) throw new RuntimeException("USER NOT FOUND");
        AppRole role = roleRepo.findByRoleName(rolename);
        if (role == null) throw new RuntimeException("ROLE NOT FOUND");
        user.getRoles().add(role);
    }

    @Override
    public void removeRoleFromUser(String username, String rolename) {
        AppUser user = userRepo.findByUsername(username);
        if(user == null) throw new RuntimeException("USER NOT FOUND");
        AppRole role = roleRepo.findByRoleName(rolename);
        if (role == null) throw new RuntimeException("ROLE NOT FOUND");
        user.getRoles().remove(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
