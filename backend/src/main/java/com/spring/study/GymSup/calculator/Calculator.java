package com.spring.study.GymSup.calculator;

import com.spring.study.GymSup.enums.DietType;
import com.spring.study.GymSup.model.diet.Diet;
import com.spring.study.GymSup.model.person.RequestPersonDTO;

public class Calculator {
    public static double calculateCalories(RequestPersonDTO person) {
        int sexVar=0;
        double dietMultplier=0;
        double tbmMultiplier=0;

        switch (person.sex()) {
            case MALE -> sexVar = 5;
            case FEMALE -> sexVar = -161;
        }
        switch (person.dietType()) {
            case CUTTING, LOW_CARB -> dietMultplier = 0.8;
            case BULKING -> dietMultplier = 1.15;
            case DEFAULT -> dietMultplier = 1.;
        }
        switch (person.routine()) {
            case SEDENTARY -> tbmMultiplier = 1.2;
            case LIGHT -> tbmMultiplier = 1.375;
            case MODERATE -> tbmMultiplier = 1.55;
            case INTENSE -> tbmMultiplier = 1.725;
        }

        double tbm = (10*person.weight() + 6.25*person.height() - 5*person.age() + sexVar);

        double total = (double) Math.round(tbm * tbmMultiplier * dietMultplier * 100)/100;

        return total;
    }

    public static double calculateProteins(RequestPersonDTO person) {
        double proteinFactor=0;

        switch (person.dietType()) {
            case BULKING, DEFAULT, LOW_CARB -> proteinFactor = 2;
            case CUTTING -> proteinFactor = 2.3;
        }

        return Math.round(person.weight()*proteinFactor*100.0)/100.0;
    }

    public static double calculateFat(RequestPersonDTO person) {
        return Math.round(person.weight()*0.8*100.0)/100.0;
    }

    public static double calculateCarbo(Diet diet, RequestPersonDTO person) {
        if(person.dietType() == DietType.LOW_CARB) {
            return 100.0;
        }

        double cal_per_protein = diet.getProteins()*4;
        double cal_per_fat = diet.getFat()*9;
        double cal_per_carbo = diet.getCalories() - (cal_per_fat+cal_per_protein);

        return Math.round((cal_per_carbo/4)*100)/100.0;
    }
}
