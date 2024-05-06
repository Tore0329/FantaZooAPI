package com.example.fantazooapi.controller;

import com.example.fantazooapi.model.dto.ZookeeperDto;
import com.example.fantazooapi.service.ZookeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zookeeper")
public class ZookeeperController {

    @Autowired
    ZookeeperService service;

    @PostMapping("/create")
    private ZookeeperDto create(@RequestBody ZookeeperDto dto) {
        return service.create(dto);
    }

    @GetMapping("/getall")
    private List<ZookeeperDto> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    private ZookeeperDto getAll(@PathVariable long id) {
        return service.getById(id);
    }

    @PutMapping("/update")
    private ZookeeperDto update(@RequestBody ZookeeperDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable long id) {
        service.delete(id);
    }
}