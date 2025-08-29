package com.spring.study.GymSup.model;

import jakarta.persistence.*;

@Entity
@Table(name = "diet_table")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timestamp;
    private Double calories;
    private Double proteins;
    private Double carbo;
    private Double fat;

    public Diet() {}

    public Diet(Double fat, Double carbo, Double proteins, Double calories, String timestamp, Long id) {
        this.fat = fat;
        this.carbo = carbo;
        this.proteins = proteins;
        this.calories = calories;
        this.timestamp = timestamp;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Double getCalories() {
        return calories;
    }

    public Double getProteins() {
        return proteins;
    }

    public Double getCarbo() {
        return carbo;
    }

    public Double getFat() {
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
