package com.example.springjavafx.services;

import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	
	private final PatientRepository patientRepository;
	
	@Autowired
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public void addPatient(Patient patient){
		patientRepository.save(patient);
	}
	
	public Patient find(String name){
		return patientRepository.findByName(name);
	}
	
	
}
