package com.spring.study.GymSup.service;

import com.spring.study.GymSup.model.Diet;
import com.spring.study.GymSup.model.Person;
import com.spring.study.GymSup.repository.DietRepository;
import com.spring.study.GymSup.repository.PersonRepository;
import com.spring.study.GymSup.utils.Calculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        diet.setCallories(calculate_callories(person));
        diet.setProteins(calculate_proteins(person));
        diet.setFat(calculate_fat(person));
        diet.setCarbo(calculate_carbo(diet, person));

        return dietRepository.save(diet);
    }
    public List<Diet> getAllDiet() {return dietRepository.findAll();}

    public Optional<Diet> getByID (Long id) { return dietRepository.findById(id); }
}
