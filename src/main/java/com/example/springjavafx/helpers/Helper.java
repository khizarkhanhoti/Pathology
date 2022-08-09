package com.example.springjavafx.helpers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class Helper {
    
    public static double x = 0;
    public static double y = 0;
    public static Parent root;
    
    
    public static void initStage(ActionEvent actionEvent, FXMLLoader loader, Resource resource) throws IOException {
    
        loader.setLocation(resource.getURL());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = loader.load();
    
        moveStage(root);
    
        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void initStage(Stage stage, Resource resource, Parent parent) throws IOException {
        
        moveStage(parent);
    
        parent.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
    
        Scene scene = new Scene(parent);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    
    public static void moveStage(Parent root){
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getX();
            y = mouseEvent.getY();
        });
    }
    
    
}
