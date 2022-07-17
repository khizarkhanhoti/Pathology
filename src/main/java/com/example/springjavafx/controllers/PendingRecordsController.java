package com.example.springjavafx.controllers;


import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.entities.Tests;
import com.example.springjavafx.repositories.PatientRepository;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PendingRecordsController implements Initializable {
	
	public AnchorPane pendingAnchorPane;
	public TextField searchNameField;
	public TextField searchCNICField;
	public TableView<Patient> recordsTable;
	public JFXButton searchButton;
	public JFXButton backButton;
	public TableColumn<Patient, String> colName;
	public TableColumn<Patient, String> colCNIC;
	public TableColumn<Patient, String> colGender;
	public TableColumn<Patient, Long> colReg;
	public TableColumn<Patient, String> colSpecimen;
	public TableColumn<Patient, String> colContact;
	public TableColumn<Patient, Tests> colTest;
	
	@Value("${primaryScene}")
	private Resource primaryScene;
	
	@Autowired
	private FXMLLoader loader;
	
	@Autowired
	private  PatientRepository patientRepository;
	
	private Stage stage;
	
	public void onBack(ActionEvent actionEvent) throws IOException {
		loader.setLocation(primaryScene.getURL());
		Parent root = loader.load();
		stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		ObservableList<Patient> patients = FXCollections.observableArrayList(patientRepository.findAll());
		
		colReg.setCellValueFactory(new PropertyValueFactory<Patient, Long>("reg"));
		colName.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
		colGender.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
		colSpecimen.setCellValueFactory(new PropertyValueFactory<Patient, String>("specimen"));
		colContact.setCellValueFactory(new PropertyValueFactory<Patient, String>("contact"));
		colCNIC.setCellValueFactory(new PropertyValueFactory<Patient, String>("cnic"));
		colTest.setCellValueFactory(new PropertyValueFactory<Patient, Tests>("tests"));
		
		recordsTable.setItems(patients);
		
	
	}
	
	public void onSearch(ActionEvent event) {
	}
}
