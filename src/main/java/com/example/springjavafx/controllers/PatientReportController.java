package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.services.LFTsService;
import com.example.springjavafx.services.PatientService;
import com.example.springjavafx.tests.collective.LFTs;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static com.example.springjavafx.helpers.Helper.*;

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
	
	public Long testID;
	
	@Value("${pendingRecordScene}")
	private Resource patientRecordScene;
	
	@Autowired
	private LFTsService lfTsService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private FXMLLoader loader;
	
	public void addLabels(Patient patient){
		this.testID = patient.getTests().getLfTs().getId();
		this.nameLabel.setText(patient.getName());
		this.cnicLabel.setText(patient.getCnic());
		this.contactLabel.setText(patient.getContact());
		this.genderLabel.setText(patient.getGender());
		this.specimenLabel.setText(patient.getSpecimen());
		this.referredByLabel.setText(patient.getReferred_by().getName());
	}
	
	public void onSubmit(ActionEvent actionEvent) throws IOException {
		String sbrResult = s_bilirubinField.getText();
		String sgptResult = sgptField.getText();
		
		LFTs lfTs = lfTsService.update(testID, sbrResult , sgptResult);
		
		System.out.println(lfTs);
		
		initStage(actionEvent, loader, patientRecordScene);
	}
	
	public void onCancel(ActionEvent actionEvent) throws IOException {
		initStage(actionEvent, loader, patientRecordScene);
	}
	
	public void setPending(){
	
	}
}
