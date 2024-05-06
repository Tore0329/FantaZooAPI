package com.example.fantazooapi.service;

import com.example.fantazooapi.mapper.AnimalMapper;
import com.example.fantazooapi.mapper.CageMapper;
import com.example.fantazooapi.model.dto.AnimalDto;
import com.example.fantazooapi.model.entity.Animal;
import com.example.fantazooapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public List<AnimalDto> getAll() {
        List<AnimalDto> dtos = new ArrayList<>();

        List<Animal> entities = animalRepository.findAll();

        for (Animal entity : entities) {
            dtos.add(AnimalMapper.toDto(entity));
        }

        return dtos;
    }

    public AnimalDto getById(long id) {
        return AnimalMapper.toDto(animalRepository.findById(id).isPresent() ? animalRepository.findById(id).get() : new Animal());
    }

    public AnimalDto update(AnimalDto dto) {
        Animal entity = animalRepository.findById(dto.getId()).get();
        entity.setName(dto.getName());
        if (dto.getCage() != null) {
            entity.setCage(CageMapper.toEntity(dto.getCage()));
        }
        return AnimalMapper.toDto(animalRepository.save(entity));
    }

    public void delete(long id) {
        animalRepository.deleteById(id);
    }

    public AnimalDto create(AnimalDto dto) {
        return AnimalMapper.toDto(animalRepository.save(AnimalMapper.toEntity(dto)));
    }
}
