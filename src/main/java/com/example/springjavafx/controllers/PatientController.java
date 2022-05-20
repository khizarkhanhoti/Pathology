package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.Doctor;
import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.repositories.DoctorRepository;
import com.example.springjavafx.repositories.HBRepository;
import com.example.springjavafx.repositories.PatientRepository;
import com.example.springjavafx.tests.byRange.HB;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.springjavafx.Helper.goBack;

@Slf4j
public class PatientController implements Initializable {

    @FXML
    public JFXTextField specimen;
    public JFXTextField name;
    public JFXComboBox<String> genderCombo;
    public JFXTextField cellNo;
    public JFXTextField cnic;
    public JFXTextField referredBy;

    @Value("${sceneUrl}")
    public Resource resource;

    @Autowired
    private FXMLLoader loader;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private HBRepository hbRepository;
    
    private ObservableList<String> genderItem;
    

    @FXML
    public void onSubmit(ActionEvent actionEvent) throws IOException {
        String specimen = this.specimen.getText();
        String name = this.name.getText();
        String gender = this.genderCombo.getValue();
        String contact = cellNo.getText();
        String cnic = this.cnic.getText();
        String referredBy = this.referredBy.getText();
    
        Doctor doctor = new Doctor();
        doctor.setName(referredBy);
        doctorRepository.save(doctor);
        
        HB hb = new HB();
        hb.setResult("34");
        hbRepository.save(hb);
        
        Patient patient = new Patient(name, gender, specimen, contact, cnic, doctor);
        patient.setHb(hb);
        System.out.println(patient);
        patientRepository.save(patient);

        goBack(actionEvent, loader, resource.getURL());
    }

    @FXML
    public void onCancel(ActionEvent actionEvent) throws IOException {
        goBack(actionEvent, loader, resource.getURL());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderItem = FXCollections.observableArrayList("Male", "Female");
        genderCombo.setItems(genderItem);
    }
}
