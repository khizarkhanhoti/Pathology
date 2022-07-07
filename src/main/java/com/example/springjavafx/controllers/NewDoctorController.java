package com.example.springjavafx.controllers;

import com.example.springjavafx.Helper;
import com.example.springjavafx.entities.Doctor;
import com.example.springjavafx.repositories.DoctorRepository;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class NewDoctorController {
	
	@Autowired
	private FXMLLoader loader;
	@Autowired
	private DoctorRepository repository;
	
	@Value("${patientScene}")
	private Resource resource;
	
	@FXML
	private JFXTextField txt_new_doctor;
	
	
	@FXML
	void addDoctor(ActionEvent event) throws IOException {
		String name = txt_new_doctor.getText();
		Doctor doctor = new Doctor(name);
		repository.save(doctor);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		System.out.println("Stage closed");
		Helper.goTo(event, loader, resource.getURL());
		stage.close();
	}
}