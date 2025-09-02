package com.spring.study.GymSup.service;

import com.spring.study.GymSup.model.diet.Diet;
import com.spring.study.GymSup.model.diet.ResponseDietDTO;
import com.spring.study.GymSup.model.person.RequestPersonDTO;
import com.spring.study.GymSup.repository.DietRepository;
import com.spring.study.GymSup.calculator.Calculator;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

@Service
public class GymSupService {
    private final DietRepository dietRepository;

    public GymSupService(DietRepository dietRepository) {
        this.dietRepository = dietRepository;
    }

    public void saveDiet(RequestPersonDTO person){
        Diet diet = new Diet();

        diet.setCalories(Calculator.calculateCalories(person));
        diet.setProteins(Calculator.calculateProteins(person));
        diet.setFat(Calculator.calculateFat(person));
        diet.setCarbo(Calculator.calculateCarbo(diet, person));
        diet.setTimestamp(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
        diet.setTotal(Calculator.calculateTotal(diet));

        dietRepository.save(diet);
    }

    public List<ResponseDietDTO> getAllDiet() {return dietRepository.findAll().stream().map(ResponseDietDTO::new).toList().reversed();}
}
