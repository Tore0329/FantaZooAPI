package com.example.fantazooapi.repository;

import com.example.fantazooapi.model.entity.Cage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CageRepository extends JpaRepository<Cage, Long> {
}
