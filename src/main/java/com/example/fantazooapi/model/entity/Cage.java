package com.example.fantazooapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cage {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    @OneToMany(mappedBy = "cage", cascade = CascadeType.ALL)
    private List<Animal> animals;

    @OneToMany(mappedBy = "cage", cascade = CascadeType.ALL)
    private List<Zookeeper> zookeepers;
}
