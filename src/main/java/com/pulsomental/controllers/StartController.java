package com.pulsomental.controllers;

import java.io.IOException;

import com.pulsomental.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartController {
    @FXML
    private Button primaryButton;

    public void initialize() {

    }

    @FXML
    private void init() throws IOException {
        App.setRoot("primary");
    }

}
