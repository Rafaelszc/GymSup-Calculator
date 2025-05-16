package com.spring.study.GymSup.model;

import jakarta.persistence.*;

@Entity
@Table(name = "diet_table")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timestamp;
    private Double callories;
    private Double proteins;
    private Double carbo;
    private Double fat;

    public Diet() {}

    public Diet(Double fat, Double carbo, Double proteins, Double callories, String timestamp, Long id) {
        this.fat = fat;
        this.carbo = carbo;
        this.proteins = proteins;
        this.callories = callories;
        this.timestamp = timestamp;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Double getCallories() {
        return callories;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setCallories(Double callories) {
        this.callories = callories;
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
