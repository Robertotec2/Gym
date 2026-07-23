package org.example.gym.domain.mapper;

import org.example.gym.domain.Trainer;
import org.example.gym.persistence.entity.TrainerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    @Mapping(source = "fullName", target = "name")
    Trainer toDomain(TrainerEntity entity);

    @Mapping(source = "name", target = "fullName")
    @Mapping(target = "hireDate", ignore = true)
    @Mapping(target = "members", ignore = true)
    TrainerEntity toEntity(Trainer domain);
}