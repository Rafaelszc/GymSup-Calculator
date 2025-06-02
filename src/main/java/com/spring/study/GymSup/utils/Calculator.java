package com.spring.study.GymSup.utils;

import com.spring.study.GymSup.enums.DietType;
import com.spring.study.GymSup.model.Diet;
import com.spring.study.GymSup.model.Person;

public abstract class Calculator {
    public Double calculateCallories(Person person) {
        int sexVar=0;
        double dietMultplier=0;
        double tbmMultiplier=0;

        switch (person.getSex()) {
            case MALE -> sexVar = 5;
            case FEMALE -> sexVar = -161;
        }
        switch (person.getDietType()) {
            case CUTTING, LOW_CARB -> dietMultplier = 0.8;
            case BULKING -> dietMultplier = 1.15;
            case DEFAULT -> dietMultplier = 1.;
        }
        switch (person.getRoutine()) {
            case SEDENTARY -> tbmMultiplier = 1.2;
            case LIGHT -> tbmMultiplier = 1.375;
            case MODERATE -> tbmMultiplier = 1.55;
            case INTENSE -> tbmMultiplier = 1.725;
        }

        double tbm = (10*person.getWeight() + 6.25*person.getHeight() - 5*person.getAge() + sexVar);

        return Math.round(tbm*tbmMultiplier*dietMultplier*100.0)/100.0;
    }

    public Double calculateProteins(Person person) {
        double proteinFactor=0;

        switch (person.getDietType()) {
            case BULKING, DEFAULT, LOW_CARB -> proteinFactor = 2;
            case CUTTING -> proteinFactor = 2.3;
        }

        return Math.round(person.getWeight()*proteinFactor*100.0)/100.0;
    }

    public Double calculateFat(Person person) {
        return Math.round(person.getWeight()*0.8*100.0)/100.0;
    }

    public Double calculateCarbo(Diet diet, Person person) {
        if(person.getDietType() == DietType.LOW_CARB) {
            return 100.0;
        }

        Double cal_per_protein = diet.getProteins()*4;
        Double cal_per_fat = diet.getFat()*9;
        Double cal_per_carbo = diet.getCallories() - (cal_per_fat+cal_per_protein);

        return Math.round((cal_per_carbo/4)*100)/100.0;
    }
}
