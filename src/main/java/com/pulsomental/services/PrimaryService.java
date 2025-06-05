package com.pulsomental.services;

import com.pulsomental.models.Projectil;

import javafx.scene.layout.Pane;

public class PrimaryService {
    // Aquí puedes agregar métodos y lógica específica para el servicio primario
    // Por ejemplo, manejo de datos, lógica de negocio, etc.

    private Projectil projectil;

    public PrimaryService() {
        // Constructor del servicio primario
        this.projectil = new Projectil(0, 0, 0, 0, 5); // Inicializa un proyectil con valores por defecto
    }

    public void reset() {
        // Lógica para reiniciar el estado del servicio
        System.out.println("Servicio primario reiniciado.");
    }

    public void simulateOver(Pane container) {
        this.projectil.generateProjectils(container, 0, 0); // Simula la generación de proyectiles
        // Lógica para simular un evento o acción
        System.out.println("Simulación completada.");
    }

}
