package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.User;
import com.example.springjavafx.helpers.Helper;
import com.example.springjavafx.repositories.UserRepository;
import com.lowagie.text.Anchor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
	@FXML
	public TextField userName;
	public PasswordField password;
	public PasswordField rePassword;
	public ComboBox<String> authorization;
	public Button register;
	public Label userLabel;
	public Label passwordLabel;
	public Label rePasswordLabel;
	
	@Value("${loginScene}")
	Resource loginScene;
	
	@Autowired
	private FXMLLoader loginLoader;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		ObservableList<String> authList = FXCollections.observableArrayList("User", "Admin");
		authorization.setItems(authList);
	}
	
	public void onRegister(ActionEvent event) throws IOException {
		Boolean isCorrect = false;
		userLabel.setText("");
		passwordLabel.setText("");
		rePasswordLabel.setText("");
		int count = userRepository.findAll().size() + 1;
		
		//Validate that name has only alphabets.
		if (userName.getText().matches(".*\\d+.*")){
			userName.clear();
			userLabel.setText("Enter Only Alphabets!(A-Z, a-z)");
		} else {
			userLabel.setText("");
//			isCorrect = true;
		}
		
		//Validates password length is 8.
		if (password.getText().length() >= 8){
			passwordLabel.setText("");
			//Validates if matches.
			if (password.getText().equals(rePassword.getText())){
				rePasswordLabel.setText("");
				isCorrect = true;
			} else {
				rePasswordLabel.setText("Password do not match!");
				passwordLabel.setText("Password do not match!");
				password.clear();
				rePassword.clear();
				isCorrect = false;
				
			}
		} else {
			password.clear();
			rePassword.clear();
			passwordLabel.setText("Password Must be 8 characters long!");
			isCorrect = false;
		}
		
		if (isCorrect){
			Long id = (long) count;
			User user = new User(id, userName.getText(), password.getText(), authorization.getValue());
			userRepository.save(user);
			Helper helper = new Helper();
			helper.initStage(event, loginLoader, loginScene);
			
		}
		
	}
	
}
