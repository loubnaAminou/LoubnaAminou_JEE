package com.example.spring_web.security.repositories;

import com.example.spring_web.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, String> {
    public AppUser findByUsername(String username);
}
