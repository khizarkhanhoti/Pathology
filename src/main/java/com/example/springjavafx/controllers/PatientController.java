package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.Doctor;
import com.example.springjavafx.entities.Patient;
import com.example.springjavafx.entities.Test;
import com.example.springjavafx.entities.Tests;
import com.example.springjavafx.helpers.ComboBoxAutoComplete;
import com.example.springjavafx.repositories.DoctorRepository;
import com.example.springjavafx.repositories.TestRepository;
import com.example.springjavafx.services.DoctorService;
import com.example.springjavafx.services.PatientService;
import com.example.springjavafx.services.TestsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Slf4j
public class PatientController implements Initializable {

    @FXML
    
    public TextField name;
    public TextField cellNo;
    public TextField cnic;
    public TextField receivedField;
    public TextField discountField;
    public ComboBox<String> referredByComboBox;
    public ComboBox<String> genderComboBox;
    public ComboBox<String> specimenComboBox;
    public ComboBox<String> testsComboBox;
    public ComboBoxAutoComplete<String> autoComplete;
    public DatePicker dobDatePicker;
    public Label amountLabel;
    public Label totalLabel;

    //Resources
    @Value("${primaryScene}")
    public Resource primaryScene;
    @Value("${patientScene}")
    public Resource patientScene;
    
    //Services
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private TestsService testsService;
    
    //Beans
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private TestRepository testRepository;
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        referredByComboBox.setOnMouseDragOver(mouseDragEvent -> referredByComboBox.setPromptText(""));
        ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
        genderComboBox.setItems(genderList);
    
        ObservableList<String> specimenList = FXCollections.observableArrayList("Home", "Lab");
        specimenComboBox.setItems(specimenList);
    
        //Lists
        referredByComboBox.setItems(getDoctorsName());
    
        testsComboBox.setItems(getTestsName());
        
        autoComplete = new ComboBoxAutoComplete<>(referredByComboBox);
       referredByComboBox.setOnKeyPressed(keyEvent -> autoComplete.handleOnKeyPressed(keyEvent));
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
    public void onSubmit() {
        String specimen = this.specimenComboBox.getValue();
        String name = this.name.getText();
        String gender = this.genderComboBox.getValue();
        String contact = cellNo.getText();
        String cnic = this.cnic.getText();
        String referredBy = referredByComboBox.getValue();
        String testRequired = testsComboBox.getValue();
//        LocalDate dob = dobDatePicker.getValue();
    
        Doctor doctor = doctorService.add(referredBy);
        Tests tests = testsService.add(testRequired);
        int amount = tests.getAmount();
        
        amountLabel.setText("" + amount);
        int discount = Integer.parseInt(discountField.getText());
        if (discount <= amount) {
            amount = amount - discount;
            totalLabel.setText("" + amount);
        }
        int received = Integer.parseInt(receivedField.getText());
        if (received <= received) {
            amount = amount - received;
            patientService.addPatient(new Patient(name, gender, specimen, contact, cnic, doctor, tests, amount));
        }
    }

    @FXML
    public void onCancel() {
        name.clear();
        cnic.clear();
        cellNo.clear();
        receivedField.setText("0");
        referredByComboBox.setValue(null);
        specimenComboBox.setValue(null);
        testsComboBox.setValue(null);
        genderComboBox.setValue(null);
        amountLabel.setText("0");
    }
    
    public void onKeyTyped(){
        referredByComboBox.setPromptText("");
        referredByComboBox.setOnKeyPressed(keyEvent -> {
            System.out.println("key typed : " + keyEvent.getCode().getName());
            autoComplete.handleOnKeyPressed(keyEvent);
        });
    }
    
    public void onSelection() {
        String test = testsComboBox.getSelectionModel().getSelectedItem();
        String amount = "" + testsService.getAmount(test);
        amountLabel.setText(amount);
    }
    
    
    public void onType(KeyEvent keyEvent) {
        autoComplete.handleOnKeyPressed(keyEvent);
    }
}
