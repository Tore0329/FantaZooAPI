package com.example.fantazooapi.controller;

import com.example.fantazooapi.model.dto.CageDto;
import com.example.fantazooapi.service.CageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cage")
public class CageController {

    @Autowired
    CageService service;

    @PostMapping("/create")
    private CageDto create(@RequestBody CageDto dto) {
        return service.create(dto);
    }

    @GetMapping("/getall")
    private List<CageDto> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    private CageDto getAll(@PathVariable long id) {
        return service.getById(id);
    }

    @PutMapping("/update")
    private CageDto update(@RequestBody CageDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable long id) {
        service.delete(id);
    }
}
