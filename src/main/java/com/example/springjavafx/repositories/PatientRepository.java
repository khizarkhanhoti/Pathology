package com.example.springjavafx.repositories;

import com.example.springjavafx.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	@Query
	public Patient findByName(String name);
}
