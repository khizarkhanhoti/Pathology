package com.example.springjavafx.services;

import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	
	public Patient findbyId(long id){
		return patientRepository.findById(id).get();
	}
	
	public List<Patient> findAllByName(String name){
		return patientRepository.findAllByName(name);
	}
	
	public Patient findByName(String name){
		return patientRepository.findByName(name);
	}
	
	public List<Patient> findAll(){
		return patientRepository.getPatients();
	}
	
}
