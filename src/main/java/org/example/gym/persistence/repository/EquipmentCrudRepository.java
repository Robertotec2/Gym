package org.example.gym.persistence.repository;

import org.example.gym.persistence.entity.EquipmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentCrudRepository extends CrudRepository<EquipmentEntity, Integer> {
}