package com.example.springjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class mainController implements Initializable {
	
	public Button exit;
	public Button patientButton;
	public AnchorPane anchorPane;
	public Label sceneLabel;
	
	@Value("${patientScene}")
	public Resource patientScene;
	
	@Value("${recordScene}")
	public Resource recordsScene;
	
	@Autowired
	private FXMLLoader patientLoader;
	@Autowired
	private FXMLLoader recordsLoader;
	@Autowired
	private FXMLLoader taskLoader;
	@Autowired
	private FXMLLoader logsLoader;
	
	
	
	public void onExit(ActionEvent actionEvent){
		Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		stage.close();
		
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		Image image = new Image("/com/example/springjavafx/icons/exit.png");
		ImageView imageView = new ImageView(image);
		exit.setGraphic(imageView);
		if (patientLoader.getRoot() == null){
			System.out.println("empty");
			try {
				patientLoader.setLocation(patientScene.getURL());
				recordsLoader.setLocation(recordsScene.getURL());
				recordsLoader.load();
				Parent parent = patientLoader.load();
				anchorPane.getChildren().removeAll();
				anchorPane.getChildren().setAll(parent);
				sceneLabel.setText("New Patient");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void onPatient() {
		
		System.out.println("patient");
		AnchorPane parent = patientLoader.getRoot();
		System.out.println(parent.toString());
		anchorPane.getChildren().removeAll();
		anchorPane.getChildren().setAll(parent);
		sceneLabel.setText("New Patient");
	}
	
	public void onRecords() {
		System.out.println("records");
		AnchorPane parent = recordsLoader.getRoot();
		System.out.println(parent.toString());
		anchorPane.getChildren().removeAll();
		anchorPane.getChildren().setAll(parent);
		sceneLabel.setText("Records");
	}
}
