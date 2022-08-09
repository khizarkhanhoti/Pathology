package com.example.springjavafx.services;

import com.example.springjavafx.entities.Doctor;
import com.example.springjavafx.repositories.DoctorRepository;
import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	
	private final DoctorRepository doctorRepository;
	
	@Autowired
	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	/* Add Doctor to Database after checking existing one.
	 * if not exists adds new entry else return existing one.
	 * */
	public Doctor add(String name){
		Doctor doctor = find(name);
		if (doctor == null) {
			System.out.println("new doctor saved!");
			doctor = new Doctor(name);
			doctorRepository.save(doctor);
			return doctor;					//Returns new Doctor.
		}
		doctor = doctorRepository.findByName(name);
		return doctor;						//Returns existing Doctor.
	}
	
	public Doctor find(String name){
		return doctorRepository.findByName(name);
	}
	
	
}
