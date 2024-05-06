package com.example.fantazooapi.service;

import com.example.fantazooapi.mapper.CageMapper;
import com.example.fantazooapi.mapper.ZookeeperMapper;
import com.example.fantazooapi.model.dto.ZookeeperDto;
import com.example.fantazooapi.model.entity.Zookeeper;
import com.example.fantazooapi.repository.ZookeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZookeeperService {

    @Autowired
    ZookeeperRepository zookeeperRepository;

    public List<ZookeeperDto> getAll() {
        List<ZookeeperDto> dtos = new ArrayList<>();

        List<Zookeeper> entities = zookeeperRepository.findAll();

        for (Zookeeper entity : entities) {
            dtos.add(ZookeeperMapper.toDto(entity));
        }

        return dtos;
    }

    public ZookeeperDto getById(long id) {
        return ZookeeperMapper.toDto(zookeeperRepository.findById(id).isPresent() ? zookeeperRepository.findById(id).get() : new Zookeeper());
    }

    public ZookeeperDto create(ZookeeperDto dto) {
        return ZookeeperMapper.toDto(zookeeperRepository.save(ZookeeperMapper.toEntity(dto)));
    }

    public ZookeeperDto update(ZookeeperDto dto) {
        Zookeeper entity = zookeeperRepository.findById(dto.getId()).get();
        entity.setName(dto.getName());

        if (dto.getCage() != null) {
            entity.setCage(CageMapper.toEntity(dto.getCage()));
        }

        return ZookeeperMapper.toDto(zookeeperRepository.save(entity));
    }

    public void delete(long id) {
        zookeeperRepository.deleteById(id);
    }
}
