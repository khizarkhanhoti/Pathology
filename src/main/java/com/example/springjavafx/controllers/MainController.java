package com.example.springjavafx.controllers;

import com.example.springjavafx.entities.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {
	
	public Button btnExit;
	public Button btnMax;
	public Button btnMin;
	public Button patientButton;
	public AnchorPane anchorPane;
	public Stage stage;
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
	private FXMLLoader reportLoader;
	@Autowired
	private FXMLLoader logsLoader;
	
	public void onExit(ActionEvent actionEvent){
		stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		stage.close();
	}

	public void onMax(ActionEvent actionEvent){
		stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());
	}

	public void onMin(ActionEvent actionEvent){
		stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		Image image = new Image("/com/example/springjavafx/icons/exit.png");
		ImageView imageView = new ImageView(image);
		btnExit.setGraphic(imageView);
		if (patientLoader.getRoot() == null){
			try {
				recordsLoader.setLocation(recordsScene.getURL());
				recordsLoader.load();
				patientLoader.setLocation(patientScene.getURL());
				Parent parent = patientLoader.load();
				anchorPane.getChildren().removeAll();
				anchorPane.getChildren().setAll(parent);
				sceneLabel.setText("New Patient");
				System.out.println("<---Main Initialized--->");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void onPatient() {
		
		System.out.println("<-----Patient----->");
		AnchorPane parent = patientLoader.getRoot();
		anchorPane.getChildren().removeAll();
		anchorPane.getChildren().setAll(parent);
		sceneLabel.setText("New Patient");
	}
	
	public void onRecords() {
		System.out.println("<-----Records----->");
		PendingRecordsController pendingRecordsController = recordsLoader.getController();
		pendingRecordsController.refresh();
		AnchorPane parent = recordsLoader.getRoot();
		anchorPane.getChildren().removeAll();
		anchorPane.getChildren().setAll(parent);
		sceneLabel.setText("Records");
	}
	
	public void onPatientReport(ActionEvent actionEvent) throws IOException {
		
//		System.out.println("<-----Report----->");
//		PendingRecordsController recordsController = recordsLoader.getController();
////		Patient patient = recordsController.recordsTable.getSelectionModel().getSelectedItem();
//		Patient patient = recordsController.getPatient();
//		if (patient != null) {
//			AnchorPane root = reportLoader.getRoot();
//			PatientReportController patientReportController = reportLoader.getController();
//			patientReportController.addLabels(patient);
//			anchorPane.getChildren().removeAll();
//			anchorPane.getChildren().setAll(root);
//			sceneLabel.setText("LFTs Report");
//		}
	}
}
