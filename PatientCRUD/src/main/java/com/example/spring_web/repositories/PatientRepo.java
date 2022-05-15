package com.example.spring_web.repositories;

import com.example.spring_web.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Page<Patient> findByNameContains(String key, Pageable pageable);
}
