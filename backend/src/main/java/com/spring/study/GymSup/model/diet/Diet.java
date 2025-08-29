package com.spring.study.GymSup.model.diet;

import jakarta.persistence.*;

@Entity
@Table(name = "diet_table")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timestamp;
    private double calories;
    private double proteins;
    private double carbo;
    private double fat;

    public Diet() {}

    public Long getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbo() {
        return carbo;
    }

    public double getFat() {
        return fat;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public void setCarbo(Double carbo) {
        this.carbo = carbo;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }
}
