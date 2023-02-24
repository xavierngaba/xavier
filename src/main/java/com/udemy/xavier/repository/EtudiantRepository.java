package com.udemy.xavier.repository;

import com.udemy.xavier.entities.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<StudentJpa, Long> {
}
