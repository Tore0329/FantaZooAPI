package com.example.fantazooapi.mapper;

import com.example.fantazooapi.model.dto.AnimalDto;
import com.example.fantazooapi.model.dto.CageDto;
import com.example.fantazooapi.model.entity.Animal;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalMapper {

    public static AnimalDto toDto(Animal entity)
    {
        AnimalDto dto = new AnimalDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        if (entity.getCage() != null) {
            CageDto cageDto = new CageDto();
            cageDto.setId(entity.getCage().getId());
            cageDto.setName(entity.getCage().getName());
            dto.setCage(cageDto);
        }

        return dto;
    }

    public static List<AnimalDto> toDtoList(List<Animal> entities) {
        return entities.stream().map(AnimalMapper::toDto).collect(Collectors.toList());
    }

    public static List<Animal> toEntityList(List<AnimalDto> dtos) {
        return dtos.stream().map(AnimalMapper::toEntity).collect(Collectors.toList());
    }

    public static Animal toEntity(AnimalDto dto)
    {
        Animal entity = new Animal();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        if (dto.getCage() != null) {
            entity.setCage(CageMapper.toEntity(dto.getCage()));
        }

        return entity;
    }
}
