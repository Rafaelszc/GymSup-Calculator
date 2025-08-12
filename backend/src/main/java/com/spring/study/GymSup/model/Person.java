package com.spring.study.GymSup.model;

import com.spring.study.GymSup.enums.DietType;
import com.spring.study.GymSup.enums.PersonRoutine;
import com.spring.study.GymSup.enums.Sex;
import jakarta.persistence.*;

@Entity
@Table(name = "person_table")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer height;
    private Double weight;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private DietType dietType;

    @Enumerated(EnumType.STRING)
    private PersonRoutine routine;

    public Person(){}

    public Person(Long id, Integer height, Double weight, Integer age, Sex sex, DietType dietType, PersonRoutine routine) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.dietType = dietType;
        this.routine = routine;
    }

    public Long getId() {
        return id;
    }

    public Integer getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public DietType getDietType() {
        return dietType;
    }

    public PersonRoutine getRoutine() {
        return routine;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }

    public void setRoutine(PersonRoutine routine) {
        this.routine = routine;
    }
}
