package com.example.fantazooapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CageDto {
    private long id;
    private String name;
    private List<AnimalDto> animals;
    private List<ZookeeperDto> zookeepers;
}
