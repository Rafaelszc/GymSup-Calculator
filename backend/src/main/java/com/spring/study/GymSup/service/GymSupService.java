package com.spring.study.GymSup.service;

import com.spring.study.GymSup.model.Diet;
import com.spring.study.GymSup.model.Person;
import com.spring.study.GymSup.repository.DietRepository;
import com.spring.study.GymSup.repository.PersonRepository;
import com.spring.study.GymSup.utils.Calculator;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class GymSupService extends Calculator {
    private final DietRepository dietRepository;
    private final PersonRepository personRepository;

    public GymSupService(DietRepository dietRepository, PersonRepository personRepository) {
        this.dietRepository = dietRepository;
        this.personRepository = personRepository;
    }

    public Diet saveDiet(Person person){
        Diet diet = new Diet();
        personRepository.save(person);

        diet.setCallories(calculateCallories(person));
        diet.setProteins(calculateProteins(person));
        diet.setFat(calculateFat(person));
        diet.setCarbo(calculateCarbo(diet, person));
        diet.setTimestamp(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));

        return dietRepository.save(diet);
    }
    public List<Diet> getAllDiet() {return dietRepository.findAll();}

    public Optional<Diet> getByID (Long id) { return dietRepository.findById(id); }
}
