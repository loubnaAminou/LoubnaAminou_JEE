package com.example.jpainheritance.repositoriers;

import com.example.jpainheritance.entities.Role;
import com.example.jpainheritance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // DAO component
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoleName(String name);
}
