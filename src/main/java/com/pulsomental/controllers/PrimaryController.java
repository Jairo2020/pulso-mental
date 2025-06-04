package com.pulsomental.controllers;

import java.io.IOException;

import com.pulsomental.App;
import com.pulsomental.models.Character;
import com.pulsomental.utils.KeyboardHandler;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class PrimaryController {
    @FXML
    private ImageView characterImg;

    @FXML
    private VBox primaryPanel;

    @FXML
    private Button reset;

    @FXML
    private Button simulateOver;

    @FXML
    private Label modeTitle;

    @FXML
    private Button startButton;

    @FXML
    private Circle c1;

    private static final String CHARACTER_PATH = "images/characters/";

    public void initialize() {
        try {
            Platform.runLater(() -> {
                primaryPanel.setFocusTraversable(false);
                primaryPanel.requestFocus();
                KeyboardHandler.addGlobalKeyListener(primaryPanel.getScene(),
                        () -> System.out.println("W pressed"),
                        () -> System.out.println("A pressed"),
                        () -> System.out.println("S pressed"),
                        () -> System.out.println("D pressed"));
            });

            reset.setOnAction(event -> reset());

            Character character = new Character(
                    "Player 1",
                    "This is a test character",
                    App.class.getResource(CHARACTER_PATH + "character1.png").toExternalForm());
            characterImg.setImage(new javafx.scene.image.Image(character.getImageUrl()));
            simulateOver.setOnAction(event -> {
                // Animación: aumentar tamaño y luego moverse rápidamente
                ScaleTransition scale = new ScaleTransition(Duration.millis(300), c1);
                scale.setToX(1.5);
                scale.setToY(1.5);

                TranslateTransition translate = new TranslateTransition(Duration.seconds(2), c1);
                translate.setToX(400); // Mover 400px a la derecha
                translate.setToY(-200); // Mover 200px hacia arriba

                // Combinamos ambas animaciones
                ParallelTransition animation = new ParallelTransition(scale, translate);
                animation.play();
                animation.setOnFinished(e -> {
                    c1.setVisible(false);
                });
            });
        } catch (Exception e) {
            System.err.println("Error initializing PrimaryController: " + e.getMessage());
        }
    }

    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("start");
    }

    private void reset() {
        c1.setVisible(true);
        // Lógica para reiniciar el estado del juego o la animación
        c1.setTranslateX(0);
        c1.setTranslateY(0);
        c1.setScaleX(1);
        c1.setScaleY(1);
    }

}
