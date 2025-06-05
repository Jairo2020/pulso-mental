package com.pulsomental.models;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Projectil {
    private double x;
    private double y;
    private double speedX;
    private double speedY;
    private double radius;

    public Projectil(double x, double y, double speedX, double speedY, double radius) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.radius = radius;
    }

    public void move() {
        x += speedX;
        y += speedY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void generateProjectils(Pane container, double startX, double startY) {
        Random random = new Random(); // Objeto para generar números aleatorios

        for (int i = 0; i < 50; i++) { // Generar 100 proyectiles
            // Crear proyectil en forma de rombo
            Polygon proyectil = new Polygon(); // Se crea un nuevo polígono
            proyectil.getPoints().addAll( // Define la forma del proyectil como un rombo mediante
                    // puntos en el plano XY
                    0.0, -10.0, // Punta superior
                    5.0, 0.0, // Lado derecho
                    0.0, 10.0, // Punta inferior
                    -5.0, 0.0 // Lado izquierdo
            );
            proyectil.setFill(Color.RED); // Se pinta de rojo

            proyectil.setLayoutX(startX); // Posición inicial en X
            proyectil.setLayoutY(startY); // Posición inicial en Y
            container.getChildren().add(proyectil); // Se añade al panel principal

            // Dirección de movimiento aleatoria
            double[] dx = { (random.nextDouble() - 0.5) * 8 }; // Movimiento en X entre -4 y 4
            double[] dy = { (random.nextDouble() - 0.5) * 8 }; // Movimiento en Y entre -4 y 4
            int[] rebotes = { 2 }; // El proyectil puede rebotar 2 veces

            // Animación que se ejecuta por ahí cada 60 FPS, pero se mide es en ms
            // Crea una animación para mover el proyectil continuamente, simulando su vuelo.
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), e -> {
                // Calcular nueva posición
                double x = proyectil.getLayoutX() + dx[0];
                double y = proyectil.getLayoutY() + dy[0];

                // Rebotar en bordes horizontales
                if (x < 0 || x > container.getWidth()) {
                    if (rebotes[0] > 0) {
                        dx[0] = -dx[0] + (random.nextDouble() - 0.5); // Cambia de dirección y agrega aleatoriedad
                        rebotes[0]--; // Resta un rebote disponible
                    } else {
                        container.getChildren().remove(proyectil); // Elimina el proyectil si ya no puede rebotar
                        return;
                    }
                }

                // Rebotar en bordes verticales
                if (y < 0 || y > container.getHeight()) {
                    if (rebotes[0] > 0) {
                        dy[0] = -dy[0] + (random.nextDouble() - 0.5); // Cambia de dirección y agrega aleatoriedad
                        rebotes[0]--; // Resta un rebote disponible
                    } else {
                        container.getChildren().remove(proyectil); // Elimina el proyectil si ya no puede rebotar
                        return;
                    }
                }

                // Actualizar posición del proyectil
                proyectil.setLayoutX(x);
                proyectil.setLayoutY(y);
            }));

            timeline.setCycleCount(400); // Ejecutar la animación durante ~6.4 segundos (400 ciclos de 16ms)
            timeline.setOnFinished(e -> container.getChildren().remove(proyectil)); // Al finalizar, eliminar el
                                                                                    // proyectil si
            // sigue en pantalla
            timeline.play(); // Iniciar animación
        }
    }
}
