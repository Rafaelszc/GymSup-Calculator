package com.spring.study.GymSup.controller;

import com.spring.study.GymSup.model.Diet;
import com.spring.study.GymSup.model.Person;
import com.spring.study.GymSup.service.GymSupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GymSupController {
    private final GymSupService service;

    public GymSupController(GymSupService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<Diet> getDiet() { return service.getAllDiet(); }

    @PostMapping("/get/{id}")
    public Optional<Diet> getDietByID (@PathVariable Long id) { return service.getByID(id); }

    @PostMapping("/save")
    public Diet saveDiet(@RequestBody Person person) { return service.saveDiet(person); }
}
