package com.example.springjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

@Slf4j
public class PrimarySceneController {

    @Autowired
    private FXMLLoader loader;
    @Autowired

    @Value("${patientScene}")
    private Resource resource;

    private Stage stage;

    public void onNewPatient(ActionEvent actionEvent) throws IOException {
        loader.setLocation(resource.getURL());
        Parent root = loader.load();
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void onPendingRecords(ActionEvent actionEvent) {
    }

    public void onHistory(ActionEvent actionEvent) {
    }

	public void onPrint(ActionEvent actionEvent) throws JRException, IOException, SQLException {
	}
}
