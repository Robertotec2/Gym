package org.example.gym.domain.mapper;

import org.example.gym.domain.Member;
import org.example.gym.persistence.entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(source = "fullName", target = "name")
    Member toDomain(MemberEntity entity);

    @Mapping(source = "name", target = "fullName")
    @Mapping(target = "measurements", ignore = true)
    MemberEntity toEntity(Member domain);
}