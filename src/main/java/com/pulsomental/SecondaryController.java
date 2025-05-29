package com.pulsomental;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SecondaryController {
    @FXML
    private Label label;

    public void initialize() {
        // This method is called by the FXMLLoader when initialization is complete
        String javaFxVersion = System.getProperty("javafx.version");
        this.label.setText("Welcome to JavaFX " + javaFxVersion + "!");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}