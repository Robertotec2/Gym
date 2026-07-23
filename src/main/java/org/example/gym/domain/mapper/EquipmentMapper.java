package org.example.gym.domain.mapper;

import org.example.gym.domain.Equipment;
import org.example.gym.persistence.entity.EquipmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {

    Equipment toDomain(EquipmentEntity entity);

    EquipmentEntity toEntity(Equipment domain);
}