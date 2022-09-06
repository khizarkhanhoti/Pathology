package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.User;
import com.example.springjavafx.helpers.Helper;
import com.example.springjavafx.repositories.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
public class LoginController implements Initializable {
    @FXML
    public TextField userField;
    public PasswordField passwordField;
    public Label  alertLabel;
    public AnchorPane loginPane;

    @Value("${mainScene}")
    public Resource mainScene;
    @Value("${registerScene}")
    public Resource registerScene;
    @Autowired
    private FXMLLoader loader;
    @Autowired
    private UserRepository userRepository;
    
    private Helper helper = new Helper();
    
    public void onLogin(ActionEvent event) throws IOException {
        
//        FontAwesomeIconView awesomeIconView = new FontAwesomeIconView(FontAwesomeIcon.U)
        
        if (checkUserPassword(userField.getText(), passwordField.getText())) {
            helper.initStage(event, loader, mainScene);
        } else {
            userField.setText("");
            passwordField.setText("");
            alertLabel.setText("Wrong Username or Password!");
        }
    }
    
    public void onKeyPressed(ActionEvent actionEvent){
        passwordField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){
                if(checkUserPassword(userField.getText(), passwordField.getText())){
                    try {
                        helper.initStage(actionEvent, loader, mainScene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    userField.setText("");
                    passwordField.setText("");
                    alertLabel.setText("Wrong Username or Password!");
                }
                keyEvent.consume();
            }
        });
    }

    private boolean checkUserPassword(String username, String password) {
        User user = userRepository.findByNameAndPassword(username, password);
        if (user != null && user.getName().equals(username)){
            user.setActive(true);
            userRepository.save(user);
            return true;
        }
        return false;
    }
    
    public void onRegister(ActionEvent event) throws IOException {
        loader.setLocation(registerScene.getURL());
        Parent parent = loader.load();
        loginPane.getChildren().removeAll();
        loginPane.getChildren().setAll(parent);
    }
    
    public void setAnchorPane(Parent parent){
        this.loginPane.getChildren().removeAll();
        this.loginPane.getChildren().setAll(parent);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    
    }
    
}
