package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.Doctor;
import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.repositories.DoctorRepository;
import com.example.springjavafx.repositories.HBRepository;
import com.example.springjavafx.repositories.PatientRepository;
import com.example.springjavafx.tests.byRange.HB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static com.example.springjavafx.Helper.goBack;

public class PatientController {

    @FXML
    public TextField specimenField;
    public TextField nameField;
    public TextField genderField;
    public TextField cellField;
    public TextField cnicField;
    public TextField referredField;

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

    @FXML
    public void onSubmit(ActionEvent actionEvent) throws IOException {
        String specimen = specimenField.getText();
        String name = nameField.getText();
        String gender = genderField.getText();
        String contact = cellField.getText();
        String cnic = cnicField.getText();
        String referredBy = referredField.getText();
    
        Doctor doctor = new Doctor();
        doctor.setName(referredBy);
        doctorRepository.save(doctor);
        
        HB hb = new HB();
        hb.setResult("34");
        hbRepository.save(hb);
        
        System.out.println("Referred By : " + referredBy + " Specimen Category : " + specimen +
                            "\nReg Code : " +  " Name : " + name +
                            "\nGender : " + gender +
                            "\nCell No. : " + contact + " CNIC : " + cnic);

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
}
