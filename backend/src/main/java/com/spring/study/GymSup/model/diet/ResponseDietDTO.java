package com.spring.study.GymSup.model.diet;

public record ResponseDietDTO(Long id, String timestamp, double calories, double proteins,
                              double carbo, double fat, int total) {

    public ResponseDietDTO(Diet diet) {
        this(
                diet.getId(), diet.getTimestamp(), diet.getCalories(), diet.getProteins(),
                diet.getCarbo(), diet.getFat(), diet.getTotal()
        );
    }
}
