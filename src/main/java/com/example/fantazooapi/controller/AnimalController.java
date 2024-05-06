package com.example.fantazooapi.controller;

import com.example.fantazooapi.model.dto.AnimalDto;
import com.example.fantazooapi.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    AnimalService service;

    @PostMapping("/create")
    private AnimalDto create(@RequestBody AnimalDto dto) {
        return service.create(dto);
    }

    @GetMapping("/getall")
    private List<AnimalDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    private AnimalDto getAll(@PathVariable long id) {
        return service.getById(id);
    }

    @PutMapping("/update")
    private AnimalDto update(@RequestBody AnimalDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable long id) {
        service.delete(id);
    }
}