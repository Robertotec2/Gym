package org.example.gym.domain.service;

import org.example.gym.domain.Trainer;
import org.example.gym.domain.mapper.TrainerMapper;
import org.example.gym.persistence.entity.TrainerEntity;
import org.example.gym.persistence.repository.TrainerCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    private final TrainerCrudRepository repository;
    private final TrainerMapper mapper;

    public TrainerService(TrainerCrudRepository repository, TrainerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Trainer> findAll() {
        List<TrainerEntity> entities = (List<TrainerEntity>) repository.findAll();
        return entities.stream().map(mapper::toDomain).toList();
    }

    public Optional<Trainer> findById(Integer id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public Trainer save(Trainer trainer) {
        TrainerEntity entity = mapper.toEntity(trainer);
        return mapper.toDomain(repository.save(entity));
    }

    public boolean delete(Integer id) {
        return findById(id).map(trainer -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }
}