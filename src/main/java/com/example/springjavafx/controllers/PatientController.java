package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.Doctor;
import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.repositories.DoctorRepository;
import com.example.springjavafx.repositories.HBRepository;
import com.example.springjavafx.repositories.PatientRepository;
import com.example.springjavafx.repositories.TestRepository;
import com.example.springjavafx.tests.Test;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.springjavafx.Helper.goTo;

@Slf4j
public class PatientController implements Initializable {

    @FXML
    public JFXComboBox<String> specimenComboBox;
    public JFXTextField name;
    public JFXComboBox<String> genderComboBox;
    public JFXTextField cellNo;
    public JFXTextField cnic;
    public JFXComboBox<String> referredByComboBox;
    public DatePicker dobDatePicker;
    public JFXComboBox testsComboBox;

    @Value("${primaryScene}")
    public Resource primaryScene;
    @Value("${patientScene}")
    public Resource patientScene;
	@Value("${newDoctorScene}")
    private Resource newDoctorScene;

    @Autowired
    private FXMLLoader loader;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private HBRepository hbRepository;
    @Autowired
    private TestRepository testRepository;
    
    private ObservableList<Doctor> referredByList;
    private ObservableList<Test> testsList;
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
        genderComboBox.setItems(genderList);
    
        ObservableList<String> specimenList = FXCollections.observableArrayList("Home", "Lab");
        specimenComboBox.setItems(specimenList);
        
        referredByList = FXCollections.observableArrayList(doctorRepository.findAll());
        referredByComboBox.setItems(getDoctorsName());
        
        testsList = FXCollections.observableArrayList(testRepository.findAll());
        testsComboBox.setItems(getTestsName());
    }
    
    //Provides names for Combo Box
    public ObservableList<String> getDoctorsName(){
        List<String> names = new ArrayList<>();
        doctorRepository.findAll().stream().forEach(doctor -> names.add(doctor.getName()));
        return FXCollections.observableArrayList(names);
    }
    
    //Provides names for Combo Box
    public ObservableList<String> getTestsName(){
        List<String> names = new ArrayList<>();
        testRepository.findAll().stream().forEach(test -> names.add(test.getName()));
        return FXCollections.observableArrayList(names);
    }
    
    @FXML
    public void onSubmit(ActionEvent actionEvent) throws IOException {
        String specimen = this.specimenComboBox.getValue();
        String name = this.name.getText();
        String gender = this.genderComboBox.getValue();
        String contact = cellNo.getText();
        String cnic = this.cnic.getText();
        Doctor referredBy = new Doctor();
        referredBy.setName(this.referredByComboBox.getValue());
        LocalDate dob = dobDatePicker.getValue();
        
        if (doctorRepository.findAll().contains(referredBy)) {
            doctorRepository.save(referredBy);
        }
        
        Patient patient = new Patient(name, gender, specimen, contact, cnic, referredBy);
        
        System.out.println(patient);
        patientRepository.save(patient);

        goTo(actionEvent, loader, primaryScene.getURL());
    }

    @FXML
    public void onCancel(ActionEvent actionEvent) throws IOException {
        goTo(actionEvent, loader, primaryScene.getURL());
    }
    
    public void addDoctor(ActionEvent actionEvent) throws IOException {
        loader.setLocation(newDoctorScene.getURL());
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(newDoctorScene.getURL());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
