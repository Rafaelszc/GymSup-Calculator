package com.spring.study.GymSup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "diet_table")
@Setter
@Getter
@AllArgsConstructor
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

}
