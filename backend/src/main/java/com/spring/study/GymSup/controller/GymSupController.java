package com.spring.study.GymSup.controller;

import com.spring.study.GymSup.model.diet.ResponseDietDTO;
import com.spring.study.GymSup.model.person.RequestPersonDTO;
import com.spring.study.GymSup.service.GymSupService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class GymSupController {
    private final GymSupService service;

    public GymSupController(GymSupService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<ResponseDietDTO> getDiet() { return service.getAllDiet(); }

    @PostMapping("/save")
    public void saveDiet(@RequestBody RequestPersonDTO person) { service.saveDiet(person); }
}
