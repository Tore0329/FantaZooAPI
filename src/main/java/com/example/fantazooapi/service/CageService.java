package com.example.fantazooapi.service;

import com.example.fantazooapi.mapper.AnimalMapper;
import com.example.fantazooapi.mapper.CageMapper;
import com.example.fantazooapi.mapper.ZookeeperMapper;
import com.example.fantazooapi.model.dto.CageDto;
import com.example.fantazooapi.model.entity.Animal;
import com.example.fantazooapi.model.entity.Cage;
import com.example.fantazooapi.model.entity.Zookeeper;
import com.example.fantazooapi.repository.CageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CageService {

    @Autowired
    CageRepository cageRepository;

    public List<CageDto> getAll() {
        List<CageDto> dtos = new ArrayList<>();

        List<Cage> entities = cageRepository.findAll();

        for (Cage entity : entities) {
            dtos.add(CageMapper.toDto(entity));
        }

        return dtos;
    }

    public CageDto getById(long id) {
        return CageMapper.toDto(cageRepository.findById(id).isPresent() ? cageRepository.findById(id).get() : new Cage());
    }

    public CageDto create(CageDto dto) {
        return CageMapper.toDto(cageRepository.save(CageMapper.toEntity(dto)));
    }

    public CageDto update(CageDto dto) {
        Cage entity = cageRepository.findById(dto.getId()).get();
        entity.setName(dto.getName());

        if (dto.getAnimals() != null) {
            entity.setAnimals(AnimalMapper.toEntityList(dto.getAnimals()));
        }

        if (dto.getZookeepers() != null) {
            entity.setZookeepers(ZookeeperMapper.toEntityList(dto.getZookeepers()));
        }

        return CageMapper.toDto(cageRepository.save(entity));
    }

    public void delete(long id) {
        cageRepository.deleteById(id);
    }

    public boolean needsInitialization() {
        return cageRepository.count() == 0;
    }

    private Cage createCage(String name, List<String> animalNames, List<String> zookeeperNames) {
        Cage cage = new Cage();
        cage.setAnimals(new ArrayList<>());
        cage.setZookeepers(new ArrayList<>());
        cage.setName(name);

        for (String animal : animalNames) {
            Animal entity = new Animal();
            entity.setName(animal);
            entity.setCage(cage);
            cage.getAnimals().add(entity);
        }

        for (String zookeeper : zookeeperNames) {
            Zookeeper entity = new Zookeeper();
            entity.setName(zookeeper);
            entity.setCage(cage);
            cage.getZookeepers().add(entity);
        }

        return cage;
    }

    public void initDB() {
        cageRepository.save(createCage("Savannah", List.of("Lion", "Giraffe", "Gazelle"), List.of("John", "Doe")));
        cageRepository.save(createCage("Polar", List.of("Penguin", "Polar Bear", "Seal"), List.of("Slemse", "Flemse")));
        cageRepository.save(createCage("Jungle", List.of("Panther", "Monkey", "Parrot"), List.of("Mike", "Hawk")));
        cageRepository.save(createCage("Desert", List.of("Snake", "Scorpion", "Vulture"), List.of("Joe")));
    }
}
