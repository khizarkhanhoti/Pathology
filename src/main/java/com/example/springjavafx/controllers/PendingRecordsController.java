package com.example.springjavafx.controllers;


import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.entities.Tests;
import com.example.springjavafx.repositories.PatientRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class PendingRecordsController implements Initializable {
	
	//TextFields
	public TextField searchNameField;
	public TextField searchCNICField;
	
	//Buttons
	public Button searchButton;
	public Button resetButton;
	
	public TableView<Patient> recordsTable;
	public TableColumn<Patient, String> colName;
	public TableColumn<Patient, String> colCNIC;
	public TableColumn<Patient, String> colGender;
	public TableColumn<Patient, Long> colReg;
	public TableColumn<Patient, String> colSpecimen;
	public TableColumn<Patient, String> colContact;
	public TableColumn<Patient, Tests> colTest;
	
	@Value("${patientReportScene}")
	private Resource patientReportScene;
	
	@Autowired
	private FXMLLoader loader;
	
	//Repository
	@Autowired
	private  PatientRepository patientRepository;
	
	//Lists
	ObservableList<Patient> patients;
	
	private Stage stage;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		patients = FXCollections.observableArrayList(patientRepository.findAll());
		
		colReg.setCellValueFactory(new PropertyValueFactory<Patient, Long>("reg"));
		colName.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
		colGender.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
		colSpecimen.setCellValueFactory(new PropertyValueFactory<Patient, String>("specimen"));
		colContact.setCellValueFactory(new PropertyValueFactory<Patient, String>("contact"));
		colCNIC.setCellValueFactory(new PropertyValueFactory<Patient, String>("cnic"));
		colTest.setCellValueFactory(new PropertyValueFactory<Patient, Tests>("tests"));
		
		recordsTable.setItems(patients);
		
	
	}
	
	public void onSearch() {
		String name = searchNameField.getText();
		ObservableList<Patient> patientsSearched = FXCollections.observableArrayList(patientRepository.findAllByName(name));
		recordsTable.setItems(patientsSearched);
		
	}
	
	public void onReset(){
		patients = FXCollections.observableArrayList(patientRepository.findAll());
		recordsTable.setItems(patients);
	}
	
	public void onOpen(ActionEvent actionEvent) throws IOException {
		loader.setLocation(patientReportScene.getURL());
		Parent root = loader.load();
		PatientReportController patientReportController = loader.getController();
		Patient patient = recordsTable.getSelectionModel().getSelectedItem();
		patientReportController.addLabels(patient);
		
		
		stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
}
