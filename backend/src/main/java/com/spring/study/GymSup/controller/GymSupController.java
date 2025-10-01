package com.spring.study.GymSup.controller;

import com.spring.study.GymSup.model.diet.ResponseDietDTO;
import com.spring.study.GymSup.model.person.RequestPersonDTO;
import com.spring.study.GymSup.service.GymSupService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class GymSupController {
    private final GymSupService service;

    public GymSupController(GymSupService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<ResponseDietDTO> getDiet() { return service.getAllDiet(); }

    @PostMapping("/save")
    public void saveDiet(@RequestBody RequestPersonDTO person) { service.saveDiet(person); }

    @DeleteMapping("/delete")
    public void deleteDiet(@RequestParam Long id) { service.deleteDiet(id); }
}
