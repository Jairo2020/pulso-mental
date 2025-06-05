package com.pulsomental;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static final String FXML_PATH = "fxml/";
    private static String title = "Pulso Mental";
    private static final int WIDTH = 640; // Ancho de la ventana
    private static final int HEIGHT = 620; // Alto de la ventana

    @Override
    public void start(Stage stage) throws IOException {
        try {
            scene = new Scene(loadFXML("start"), WIDTH, HEIGHT);

            stage.setScene(scene);
            stage.setTitle(title);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.err.println("Error al cargar la aplicación: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void setRoot(String fxml) throws IOException {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            System.err.println("Error al cambiar la raíz: " + e.getMessage());
            throw e;
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(FXML_PATH + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}