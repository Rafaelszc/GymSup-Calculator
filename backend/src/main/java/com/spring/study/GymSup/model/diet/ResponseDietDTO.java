package com.spring.study.GymSup.model.diet;

public record ResponseDietDTO(Long id, String timestamp, double calories,
                              double proteins, double carbo, double fat) {

    public ResponseDietDTO(Diet diet) {
        this(
            diet.getId(), diet.getTimestamp(), diet.getCalories(),
            diet.getProteins(), diet.getCarbo(), diet.getFat()
        );
    }
}
