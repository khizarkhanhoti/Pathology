package com.example.springjavafx.controllers;


import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.entities.Tests;
import com.example.springjavafx.helpers.Helper;
import com.example.springjavafx.services.PatientService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.util.ResourceBundle;


@Component
public class PendingRecordsController implements Initializable {
	
	//TextFields
	public TextField searchNameField;
	public TextField searchCNICField;
	
	//Buttons
	public Button searchButton;
	public Button resetButton;
	
	//TableView
	public TableView<Patient> recordsTable;
	public TableColumn<Patient, String> colName;
	public TableColumn<Patient, String> colCNIC;
	public TableColumn<Patient, String> colGender;
	public TableColumn<Patient, Long> colReg;
	public TableColumn<Patient, String> colSpecimen;
	public TableColumn<Patient, String> colContact;
	public TableColumn<Patient, Tests> colTest;
	
	//AnchorPane
	public AnchorPane recordsAnchorPane;
	
	//Service
	@Autowired
	private PatientService patientService;
	@Autowired
	private FXMLLoader reportLoader;
	
	//Value
	@Value("${lftsScene}")
	Resource lftScene;
	
	//Lists
	public ObservableList<Patient> patients;
	private Patient patient;
	PatientReportController patientReportController;
	private Stage stage;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		patients = FXCollections.observableArrayList(patientService.findAll());
		
		colReg.setCellValueFactory(new PropertyValueFactory<>("reg"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		colSpecimen.setCellValueFactory(new PropertyValueFactory<>("specimen"));
		colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
		colCNIC.setCellValueFactory(new PropertyValueFactory<>("cnic"));
		colTest.setCellValueFactory(new PropertyValueFactory<>("tests"));
		recordsTable.setItems(patients);
		try {
			reportLoader.setLocation(lftScene.getURL());
			reportLoader.load();
			patientReportController = reportLoader.getController();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		recordsTable.setOnMouseClicked(mouseEvent -> {
			patient = recordsTable.getSelectionModel().getSelectedItem();
			patientReportController.addLabels(patient);
			Parent parent = reportLoader.getRoot();
			recordsAnchorPane.getChildren().removeAll();
			recordsAnchorPane.getChildren().setAll(parent);
			mouseEvent.consume();
		});
		System.out.println("<-----Records Initialized----->");
	}
	
	public void refresh(){
		patients = FXCollections.observableArrayList(patientService.findAll());
		recordsTable.setItems(patients);
	}
	
	public void onSearch() {
		String name = searchNameField.getText();
		System.out.println(searchNameField.getText());
		ObservableList<Patient> patientsSearched = FXCollections.observableArrayList(patientService.findAllByName(name));
		recordsTable.setItems(patientsSearched);
		
	}
	
	public void onReset(){
		patients = FXCollections.observableArrayList(patientService.findAll());
		recordsTable.setItems(patients);
	}
	
	public void onClick(MouseEvent mouseEvent) {
	}
	
	public Patient getPatient(){
		return this.patient;
	}

}
