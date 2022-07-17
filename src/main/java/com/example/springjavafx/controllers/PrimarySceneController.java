package com.example.springjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

@Slf4j
public class PrimarySceneController implements Initializable {
    
    public Button patientButton;
    public Button pendingRecordsButton;
    public Button historyButton;
    public Button printButton;
    

    @Autowired
    private FXMLLoader loader;

    @Value("${patientScene}")
    private Resource patientScene;
    @Value("${pendingScene}")
    private Resource pendingScene;
    
    //Global Variable
    private Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Patient Button
        Image patientIcon = new Image("com/example/springjavafx/patientIcon.png");
        ImageView patientView = new ImageView(patientIcon);
        patientView.setFitHeight(169);
        patientView.setFitWidth(300);
        patientButton.setGraphic(patientView);
    }

    public void onNewPatient(ActionEvent actionEvent) throws IOException {
        loader.setLocation(patientScene.getURL());
        Parent root = loader.load();
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void onPendingRecords(ActionEvent actionEvent) throws IOException {
        loader.setLocation(pendingScene.getURL());
        Parent root = loader.load();
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onHistory(ActionEvent actionEvent) {
    }

	public void onPrint(ActionEvent actionEvent) throws JRException, IOException, SQLException {
	}
 
}
