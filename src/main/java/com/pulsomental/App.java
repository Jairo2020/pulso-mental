package com.pulsomental;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        scene.setOnKeyPressed(event -> handleKeyPress(event));
        stage.setScene(scene);
        stage.show();
    }

    private void handleKeyPress(KeyEvent event) {
        KeyCode code = event.getCode();

        switch (code) {
            case W:
                System.out.println("Se presionó W");
                break;
            case A:
                System.out.println("Se presionó A");
                break;
            case S:
                System.out.println("Se presionó S");
                break;
            case D:
                System.out.println("Se presionó D");
                break;
            case UP:
                System.out.println("Flecha Arriba");
                break;
            case DOWN:
                System.out.println("Flecha Abajo");
                break;
            case LEFT:
                System.out.println("Flecha Izquierda");
                break;
            case RIGHT:
                System.out.println("Flecha Derecha");
                break;
            default:
                System.out.println("Tecla presionada: " + code);
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}