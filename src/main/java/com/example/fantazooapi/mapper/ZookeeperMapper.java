package com.example.fantazooapi.mapper;

import com.example.fantazooapi.model.dto.CageDto;
import com.example.fantazooapi.model.dto.ZookeeperDto;
import com.example.fantazooapi.model.entity.Zookeeper;

import java.util.List;

import java.util.stream.Collectors;

public class ZookeeperMapper {

    public static ZookeeperDto toDto(Zookeeper entity)
    {
        ZookeeperDto dto = new ZookeeperDto();
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

    public static List<ZookeeperDto> toDtoList(List<Zookeeper> entities) {
        return entities.stream().map(ZookeeperMapper::toDto).collect(Collectors.toList());
    }

    public static List<Zookeeper> toEntityList(List<ZookeeperDto> dtos) {
        return dtos.stream().map(ZookeeperMapper::toEntity).collect(Collectors.toList());
    }

    public static Zookeeper toEntity(ZookeeperDto dto)
    {
        Zookeeper entity = new Zookeeper();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        if (dto.getCage() != null) {
            entity.setCage(CageMapper.toEntity(dto.getCage()));
        }

        return entity;
    }
}