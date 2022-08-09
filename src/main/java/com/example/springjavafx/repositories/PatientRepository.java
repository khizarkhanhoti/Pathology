package com.example.springjavafx.repositories;

import com.example.springjavafx.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	@Query
	public List<Patient> findAllByName(String name);
	
	@Query
	public Patient findByName(String name);
}
