package com.example.springjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static com.example.springjavafx.Helper.goBack;

public class LoginController {
    @FXML
    public TextField userField;
    public TextField passwordField;
    public Label usernameErrorLabel;
    public Label passwordErrorLabel;

    @Value("${primaryScene}")
    public Resource resource;
    @Autowired
    private FXMLLoader loader;

//    @Autowired
//    public LoginController(FXMLLoader loader){
//        this.loader = loader;
//    }


    public void onLogin(ActionEvent event) throws IOException {
        String username = userField.getText();
        String password = passwordField.getText();
        System.out.println("Username : " + username +
                            "\nPassword : " + password);
        if (checkUserPassword(username, password)) {
            goBack(event, loader, resource.getURL());
        } else {
            userField.setText("");
            usernameErrorLabel.setText("Wrong Username!");
            passwordField.setText("");
            passwordErrorLabel.setText("Wrong password!");
        }
    }

    private boolean checkUserPassword(String username, String password) {
        return username.equals("khizar") && password.equals("khan");
    }
}
