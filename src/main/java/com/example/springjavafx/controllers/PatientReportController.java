package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.services.PatientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Slf4j
public class PatientReportController {

	public AnchorPane reportAnchorPane;
	public Label nameLabel;
	public Label cnicLabel;
	public Label contactLabel;
	public Label genderLabel;
	public Label specimenLabel;
	public Label referredByLabel;
	public TextField s_bilirubinField;
	public TextField sgptField;
	public TextField alkaline_phosphataseField;

	public Patient patient;
	public Long testID;

	@Value("${recordScene}")
	private Resource patientRecordScene;

	@Autowired
	private PatientService patientService;
	@Autowired
	private FXMLLoader recordLoader;

	public void addLabels(Patient patient){
		this.patient = patient;
		this.testID = patient.getTest().getId();
		this.nameLabel.setText(patient.getName());
		this.cnicLabel.setText(patient.getCnic());
		this.contactLabel.setText(patient.getContact());
		this.genderLabel.setText(patient.getGender());
		this.specimenLabel.setText(patient.getSpecimen());
		this.referredByLabel.setText(patient.getReferred_by().getName());
	}

	public void onSubmit(ActionEvent actionEvent) throws IOException {

		recordLoader.setLocation(patientRecordScene.getURL());
		recordLoader.load();
		reportAnchorPane.getChildren().removeAll();
		Parent parent = recordLoader.getRoot();
		reportAnchorPane.getChildren().setAll(parent);
	}

	public void onCancel(ActionEvent actionEvent) throws IOException {
		s_bilirubinField.clear();
		alkaline_phosphataseField.clear();
		sgptField.clear();
		recordLoader.setLocation(patientRecordScene.getURL());
		recordLoader.load();
		reportAnchorPane.getChildren().removeAll();
		Parent parent = recordLoader.getRoot();
		reportAnchorPane.getChildren().setAll(parent);
	}

}
