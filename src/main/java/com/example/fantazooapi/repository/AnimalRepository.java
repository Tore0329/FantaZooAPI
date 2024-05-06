package com.example.fantazooapi.repository;

import com.example.fantazooapi.model.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
