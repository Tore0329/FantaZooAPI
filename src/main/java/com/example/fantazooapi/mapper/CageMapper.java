package com.example.fantazooapi.mapper;

import com.example.fantazooapi.model.dto.AnimalDto;
import com.example.fantazooapi.model.dto.CageDto;
import com.example.fantazooapi.model.dto.ZookeeperDto;
import com.example.fantazooapi.model.entity.Cage;

import java.util.List;
import java.util.stream.Collectors;

public class CageMapper {

    public static CageDto toDto(Cage entity)
    {
        CageDto dto = new CageDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        if (entity.getAnimals() != null) {
            List<AnimalDto> animalDtos = entity.getAnimals().stream()
                    .map(animal -> {
                        AnimalDto simpleDto = new AnimalDto();
                        simpleDto.setId(animal.getId());
                        simpleDto.setName(animal.getName());
                        return simpleDto;
                    }).collect(Collectors.toList());
            dto.setAnimals(animalDtos);
        }

        if (entity.getZookeepers() != null) {
            List<ZookeeperDto> zookeeperDtos = entity.getZookeepers().stream()
                    .map(zookeeper -> {
                        ZookeeperDto simpleDto = new ZookeeperDto();
                        simpleDto.setId(zookeeper.getId());
                        simpleDto.setName(zookeeper.getName());
                        return simpleDto;
                    }).collect(Collectors.toList());
            dto.setZookeepers(zookeeperDtos);
        }

        return dto;
    }

    public static Cage toEntity(CageDto dto)
    {
        Cage entity = new Cage();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        if (dto.getAnimals() != null) {
            entity.setAnimals(AnimalMapper.toEntityList(dto.getAnimals()));
        }

        if (dto.getZookeepers() != null) {
            entity.setZookeepers(ZookeeperMapper.toEntityList(dto.getZookeepers()));
        }

        return entity;
    }

    public static List<CageDto> toDtoList(List<Cage> entities) {
        return entities.stream().map(CageMapper::toDto).collect(Collectors.toList());
    }

    public static List<Cage> toEntityList(List<CageDto> dtos) {
        return dtos.stream().map(CageMapper::toEntity).collect(Collectors.toList());
    }
}
