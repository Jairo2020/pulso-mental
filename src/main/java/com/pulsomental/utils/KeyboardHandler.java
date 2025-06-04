package com.pulsomental.utils;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardHandler {

    public static void addGlobalKeyListener(Scene scene, Runnable onW, Runnable onA, Runnable onS, Runnable onD) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                onW.run();
            } else if (event.getCode() == KeyCode.A
                    || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.UP) {
                onA.run();
            } else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
                onS.run();
            } else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
                onD.run();
            }
        });
    }

    public void handleKeyPress(KeyEvent event) {
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
}