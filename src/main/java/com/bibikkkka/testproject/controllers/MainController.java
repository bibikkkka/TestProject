package com.bibikkkka.testproject.controllers;

import com.bibikkkka.testproject.entities.Cat;
import com.bibikkkka.testproject.repositories.CatRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepository catRepository;
    private final ObjectMapper objectMapper;


    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat) {
        log.info("New row: {}", catRepository.save(cat));
    }

    @GetMapping("/api/all")
    public List<Cat> getAllCats() {
        try {
            return catRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api/get")
    public Cat getCatById(@RequestParam int id) {
        return catRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/api/del")
    public void deleteCatById(@RequestParam int id) {
        catRepository.deleteById(id);
    }

    @PutMapping("/api/put")
    public String updateCatById(@RequestBody Cat cat) {
        if (!catRepository.existsById(cat.getId())) {
            return "No such row";
        }
        return catRepository.save(cat).toString();
    }

}
