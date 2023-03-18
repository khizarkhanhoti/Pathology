package com.example.springjavafx.controllers;


import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.entities.Test;
import com.example.springjavafx.entities.Tests;
import com.example.springjavafx.helpers.Helper;
import com.example.springjavafx.repositories.PatientRepository;
import com.example.springjavafx.services.PatientService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


@Component
public class PendingRecordsController implements Initializable {
	
	//TextFields
	public TextField nameTF;
	public TextField cnicTF;

	//Buttons
	public Button searchBtn;
	
	//TableView
	public TableView<Patient> recordsTable;
	public TableColumn<Patient, String> colName;
	public TableColumn<Patient, String> colCNIC;
	public TableColumn<Patient, String> colGender;
	public TableColumn<Patient, Long> colID;
	public TableColumn<Patient, Test> colTest;
	public TableColumn<Patient, Integer> colAmount;
	public AnchorPane pane;
	
	//Service
	@Autowired
	private PatientRepository patientRepository;
	
	//Lists
	public ObservableList<Patient> patients;
	PatientReportController patientReportController;
	private Stage stage;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		List<Patient> patients1 = patientRepository.findAll();
		patients = FXCollections.observableArrayList(patients1);
		
		colID.setCellValueFactory(new PropertyValueFactory<>("reg"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		colCNIC.setCellValueFactory(new PropertyValueFactory<>("cnic"));
		colTest.setCellValueFactory(new PropertyValueFactory<>("test"));
		colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		recordsTable.setEditable(true);
		recordsTable.setItems(patients);

		for (Patient patient: patients1
			 ) {
			System.out.println(patient.toString());
		}

		System.out.println("<-----Records Initialized----->");
	}
	
	public void refresh(){
		List<Patient> patientList = patientRepository.findAll();
		patients = FXCollections.observableArrayList(patientList);
		recordsTable.setItems(patients);
	}
	
	public void onSearch() {
		String name = nameTF.getText();
		System.out.println(nameTF.getText());
		ObservableList<Patient> patientsSearched = FXCollections.observableArrayList(patientRepository.findAllByName(name));
		recordsTable.setItems(patientsSearched);
	}
	
	public void onReset(){
		patients = FXCollections.observableArrayList(patientRepository.findAll());
		recordsTable.setItems(patients);
		nameTF.setText("");
		cnicTF.setText("");

	}
	
	public void onClick(MouseEvent mouseEvent) {
		Patient patient = recordsTable.getSelectionModel().getSelectedItem();
		Test test = patient.getTest();
		stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
	}

	public void onEditChanged(TableColumn.CellEditEvent<Patient, String> patientStringCellEditEvent){
		recordsTable.setEditable(true);
		Patient patient = recordsTable.getSelectionModel().getSelectedItem();
		patient.setAmount(Integer.parseInt(patientStringCellEditEvent.getNewValue()));
	}

//	public Patient getPatient(){
//		return new Patient();
//	}

}
