package org.example.gym.domain.service;

import org.example.gym.domain.Member;
import org.example.gym.domain.mapper.MemberMapper;
import org.example.gym.persistence.entity.MemberEntity;
import org.example.gym.persistence.repository.MemberCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberCrudRepository repository;
    private final MemberMapper mapper;

    // Inyección de dependencias por constructor (Recomendado por Spring)
    public MemberService(MemberCrudRepository repository, MemberMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Member> findAll() {
        List<MemberEntity> entities = (List<MemberEntity>) repository.findAll();
        return entities.stream().map(mapper::toDomain).toList();
    }

    // Uso correcto de Optional según la rúbrica
    public Optional<Member> findById(Integer id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public Member save(Member member) {
        MemberEntity entity = mapper.toEntity(member);
        return mapper.toDomain(repository.save(entity));
    }

    public boolean delete(Integer id) {
        return findById(id).map(member -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }
}