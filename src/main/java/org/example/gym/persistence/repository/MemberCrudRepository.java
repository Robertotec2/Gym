package org.example.gym.persistence.repository;

import org.example.gym.persistence.entity.MemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<MemberEntity, Integer> {
}