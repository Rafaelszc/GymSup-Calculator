package com.spring.study.GymSup.model.person;

import com.spring.study.GymSup.enums.DietType;
import com.spring.study.GymSup.enums.PersonRoutine;
import com.spring.study.GymSup.enums.Sex;

public record RequestPersonDTO(int height, double weight, int age,
                               Sex sex, DietType diet, PersonRoutine routine) {

    public RequestPersonDTO(int height, double weight, int age, Sex sex, DietType diet, PersonRoutine routine) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.diet = diet;
        this.routine = routine;
    }
}
