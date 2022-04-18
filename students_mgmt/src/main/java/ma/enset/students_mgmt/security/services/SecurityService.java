package ma.enset.students_mgmt.security.services;

import ma.enset.students_mgmt.security.entities.RoleApp;
import ma.enset.students_mgmt.security.entities.UserApp;

public interface SecurityService {
    UserApp newUser(String username, String password, String confirm);
    RoleApp newRole(String name);
    void addRoleToUser(String username, String rolename);
    UserApp loadByUsername(String username);
}
