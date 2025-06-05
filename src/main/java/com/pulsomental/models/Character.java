package com.pulsomental.models;

public class Character {
    private String name;
    private String description;
    private String imageUrl;
    private double x;
    private Integer steps = 10;

    private double y;

    public Character(String name, String description, String imageUrl, double x, double y) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.x = x;
        this.y = y;
    }

    // #region Getters and Setters
    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer speed) {
        this.steps = speed;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // #endregion
}
