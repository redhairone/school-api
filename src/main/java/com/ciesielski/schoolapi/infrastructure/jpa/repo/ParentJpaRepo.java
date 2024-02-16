package com.ciesielski.schoolapi.infrastructure.jpa.repo;

import com.ciesielski.schoolapi.domain.model.Parent;
import com.ciesielski.schoolapi.domain.repo.ParentRepo;
import com.ciesielski.schoolapi.infrastructure.entities.ParentEntity;
import com.ciesielski.schoolapi.infrastructure.entities.mapper.ParentMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentJpaRepo extends JpaRepository<ParentEntity, Long>, ParentRepo {

    default Optional<Parent> findParentById(Long id) {
        final ParentMapper parentMapper = new ParentMapper();
        return this.findById(id).map(parentMapper::map);
    }
}
