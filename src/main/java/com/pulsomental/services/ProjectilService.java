package com.pulsomental.services;

import com.pulsomental.models.Projectil;

public class ProjectilService {
    // Aquí puedes implementar la lógica relacionada con los proyectiles
    // Por ejemplo, métodos para crear, mover o eliminar proyectiles

    public void createProjectil(double x, double y, double speedX, double speedY, double radius) {
        // Lógica para crear un nuevo proyectil
        // Por ejemplo, instanciar un objeto Projectil y agregarlo a una lista
    }

    public void moveProjectil(Projectil projectil) {
        // Lógica para mover un proyectil
        projectil.move();
    }

    public void removeProjectil(Projectil projectil) {
        // Lógica para eliminar un proyectil de la lista
    }
}
