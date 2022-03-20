package com.example.jpainheritance.service;

import com.example.jpainheritance.entities.Role;
import com.example.jpainheritance.entities.User;
import com.example.jpainheritance.repositoriers.RoleRepo;
import com.example.jpainheritance.repositoriers.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service // metier component
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    @Override
    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        /*String pw = user.getPassword();
        user.setPassword(passwordEncoder.encode(pw));*/
        return userRepo.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public User findUserByUserName(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public Role findRoleByRoleName(String name) {
        return roleRepo.findByRoleName(name);
    }

    @Override
    public void addRoletoUser(String userName, String roleName) {
        User user = findUserByUserName(userName);
        Role role = findRoleByRoleName(roleName);
            user.getRoles().add(role); // List void ==> NullPointerException
            role.getUsers().add(user); // bidirectionnelle

        /*
        ==> Update
        userRepo.save(user); // no need : thanks to transactional(update = commit)
         */
    }

    @Override
    public User authenticate(String usename, String password) {
        User user = findUserByUserName(usename);
        if(user == null) throw new RuntimeException("Bad credentials");
        if (user.getPassword().equals(password)){
            return user;
        }

        throw new RuntimeException("Bad credentials");
    }
}
