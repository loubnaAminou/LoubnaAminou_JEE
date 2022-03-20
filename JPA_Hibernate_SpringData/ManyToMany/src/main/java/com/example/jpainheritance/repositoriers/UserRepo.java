package com.example.jpainheritance.repositoriers;

import com.example.jpainheritance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUsername(String name);
}
