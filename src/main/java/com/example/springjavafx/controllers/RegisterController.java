package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static com.example.springjavafx.Helper.goTo;

public class RegisterController {
	
	public JFXTextField userName;
	public JFXPasswordField password;
	public JFXPasswordField rePassword;
	public JFXComboBox<String> authorization;
	public JFXButton register;
	public Label userFieldLabel;
	public Label passwordLabel;
	public Label rePasswordLabel;
	
	@Value("${loginScene}")
	Resource loginScene;
	@Autowired
	private FXMLLoader loader;
	
	public void onRegister(ActionEvent event) throws IOException {
		Boolean isCorrect = false;
		userFieldLabel.setText("");
		passwordLabel.setText("");
		rePasswordLabel.setText("");
		
		if (userName.getText().matches(".*\\d+.*")){
			userName.clear();
			userFieldLabel.setText("Enter Only Alphabets!(A-Z, a-z)");
		} else {
			userFieldLabel.setText("");
			isCorrect = true;
		}
		
		if (password.getText().length() < 8){
			password.clear();
			passwordLabel.setText("Password Must be 8 characters long!");
			isCorrect = false;
		} else {
			passwordLabel.setText("");
			isCorrect = true;
			if (!password.getText().equals(rePassword.getText())){
				rePasswordLabel.setText("Password do not match!");
				passwordLabel.setText("Password do not match!");
				isCorrect = false;
			} else {
				rePasswordLabel.setText("");
				isCorrect = true;}
		}
		
		if (isCorrect){
			User user = new User(userName.getText(), password.getText(), authorization.getValue());
			goTo(event, loader, loginScene.getURL());
		}
		
	}
}
