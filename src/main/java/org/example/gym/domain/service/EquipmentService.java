package org.example.gym.domain.service;

import org.example.gym.domain.Equipment;
import org.example.gym.domain.mapper.EquipmentMapper;
import org.example.gym.persistence.entity.EquipmentEntity;
import org.example.gym.persistence.repository.EquipmentCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    private final EquipmentCrudRepository repository;
    private final EquipmentMapper mapper;

    public EquipmentService(EquipmentCrudRepository repository, EquipmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Equipment> findAll() {
        List<EquipmentEntity> entities = (List<EquipmentEntity>) repository.findAll();
        return entities.stream().map(mapper::toDomain).toList();
    }

    public Optional<Equipment> findById(Integer id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public Equipment save(Equipment equipment) {
        EquipmentEntity entity = mapper.toEntity(equipment);
        return mapper.toDomain(repository.save(entity));
    }

    public boolean delete(Integer id) {
        return findById(id).map(equipment -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }
}