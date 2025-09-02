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
    private int total;

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

    public int getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public void setCarbo(double carbo) {
        this.carbo = carbo;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
