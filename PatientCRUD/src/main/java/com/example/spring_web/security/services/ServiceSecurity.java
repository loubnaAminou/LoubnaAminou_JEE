package com.example.spring_web.security.services;

import com.example.spring_web.security.entities.AppRole;
import com.example.spring_web.security.entities.AppUser;

public interface ServiceSecurity {
    AppUser saveNewUser(String username, String password, String confirmPwd);
    AppRole saveNewRole(String rolename, String desc);
    void addRoleToUser(String username, String rolename);
    void removeRoleFromUser(String username, String rolename);
    AppUser loadUserByUsername(String username);
}
