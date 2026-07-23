package org.example.gym.persistence.repository;

import org.example.gym.persistence.entity.TrainerEntity;
import org.springframework.data.repository.CrudRepository;

public interface TrainerCrudRepository extends CrudRepository<TrainerEntity, Integer> {
}