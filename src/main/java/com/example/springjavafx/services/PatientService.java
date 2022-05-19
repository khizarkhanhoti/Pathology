package com.example.springjavafx.services;

import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public void addPatient(Patient patient){
	
	}
}
