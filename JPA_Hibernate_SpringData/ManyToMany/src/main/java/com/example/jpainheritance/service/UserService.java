package com.example.jpainheritance.service;

import com.example.jpainheritance.entities.Role;
import com.example.jpainheritance.entities.User;

public interface UserService {
    User addUser(User user);
    Role addRole(Role role);
    User findUserByUserName(String name);
    Role findRoleByRoleName(String name);
    void addRoletoUser(String roleName, String userName);
    User authenticate(String usename, String password);
}
