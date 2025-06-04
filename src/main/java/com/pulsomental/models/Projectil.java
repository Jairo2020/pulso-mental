package com.pulsomental.models;

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
}
