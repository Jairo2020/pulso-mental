package com.pulsomental.controllers;

import java.io.IOException;

import com.pulsomental.App;
import com.pulsomental.models.Character;
import com.pulsomental.services.PrimaryService;
import com.pulsomental.utils.KeyboardHandler;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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

    @FXML
    private GridPane contentGame;

    private PrimaryService primaryService = new PrimaryService();

    private static final String CHARACTER_PATH = "images/characters/";

    public void initialize() {
        try {
            reset.setOnAction(event -> reset());

            Character character = new Character(
                    "Player 1",
                    "This is a test character",
                    App.class.getResource(CHARACTER_PATH + "character1.png").toExternalForm(),
                    0,
                    0);
            characterImg.setImage(new javafx.scene.image.Image(character.getImageUrl()));
            simulateOver.setOnAction(event -> {
                // // Animación: aumentar tamaño y luego moverse rápidamente
                // ScaleTransition scale = new ScaleTransition(Duration.millis(300), c1);
                // scale.setToX(1.5);
                // scale.setToY(1.5);

                // TranslateTransition translate = new TranslateTransition(Duration.seconds(2),
                // c1);
                // translate.setToX(400); // Mover 400px a la derecha
                // translate.setToY(-200); // Mover 200px hacia arriba

                // // Combinamos ambas animaciones
                // ParallelTransition animation = new ParallelTransition(scale, translate);
                // animation.play();
                // animation.setOnFinished(e -> {
                // c1.setVisible(false);
                // });

                modeTitle.setText("Modo Reflejos");

                Platform.runLater(() -> {
                    primaryPanel.setFocusTraversable(false);
                    primaryPanel.requestFocus();
                    KeyboardHandler.addGlobalKeyListener(primaryPanel.getScene(),
                            () -> {
                                // Mover arriba si no supera el borde superior
                                double top = character.getY() - characterImg.getBoundsInParent().getHeight();
                                System.out.println("Top: " + top);
                                System.out
                                        .println("Content height: " + -contentGame.getBoundsInParent().getHeight() / 2);
                                if (top >= -(contentGame.getBoundsInParent().getHeight() / 2)) {
                                    character.setY(character.getY() - character.getSteps());
                                    characterImg.setTranslateY(character.getY());
                                }
                            },
                            () -> {
                                double left = character.getX() - characterImg.getBoundsInParent().getWidth();
                                System.out.println("Left: " + left);
                                System.out.println("Content width: " + -contentGame.getBoundsInParent().getWidth() / 2);
                                if (left >= -contentGame.getBoundsInParent().getWidth() / 2) {
                                    // Mover izquierda si no supera el borde izquierdo
                                    character.setX(character.getX() - character.getSteps());
                                    characterImg.setTranslateX(character.getX());
                                }
                            },
                            () -> {
                                // Mover abajo si no supera el borde inferior
                                double bottom = character.getY() + characterImg.getBoundsInParent().getHeight();
                                System.out.println("Bottom: " + bottom);
                                System.out.println("Content height: " + contentGame.getHeight());
                                if (bottom <= contentGame.getHeight() / 2) {
                                    character.setY(character.getY() + character.getSteps());
                                    characterImg.setTranslateY(character.getY());
                                }
                            },
                            () -> {
                                // Mover derecha si no supera el borde derecho
                                double right = character.getX() + characterImg.getBoundsInParent().getWidth();
                                System.out.println("Bottom: " + right);
                                System.out.println("Content height: " + contentGame.getHeight());
                                if (right <= contentGame.getWidth() / 2) {
                                    character.setX(character.getX() + character.getSteps());
                                    characterImg.setTranslateX(character.getX());
                                }
                            });
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
        characterImg.setTranslateX(0);
        characterImg.setTranslateY(0);

        modeTitle.setText("Modo Memoria");
    }

}
