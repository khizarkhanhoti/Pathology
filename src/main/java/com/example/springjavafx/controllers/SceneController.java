package com.example.springjavafx.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SceneController {
	@FXML
	private AnchorPane anchor_paneCenter;
	@FXML
	private AnchorPane anchor_paneLeft;
	@FXML
	private AnchorPane anchor_paneRight;
	@FXML
	private JFXButton btn_print_preview;
	@FXML
	private JFXButton btn_save;
	@FXML
	private Label label_title;
	@FXML
	private Pane pane_top;
}
