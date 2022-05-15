package com.example.spring_web.security.repositories;

import com.example.spring_web.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole, Long> {
    public AppRole findByRoleName(String rolename);

}
