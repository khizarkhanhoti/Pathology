package com.example.springjavafx.repositories;

import com.example.springjavafx.entities.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	@Query("From Patient WHERE upper(name) Like concat('%', upper(?1), '%')")
	public List<Patient> findAllByName(String name);
	
	@Query("From Patient Where isPending = true")
	public List<Patient> getPatients();
	
	@Query
	public Patient findByName(String name);
	
}
