package com.lab05.lab05;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LabFiveController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}