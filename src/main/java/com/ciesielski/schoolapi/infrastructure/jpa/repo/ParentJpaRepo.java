package com.ciesielski.schoolapi.infrastructure.jpa.repo;

import com.ciesielski.schoolapi.domain.repo.ParentRepo;
import com.ciesielski.schoolapi.infrastructure.entities.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentJpaRepo extends JpaRepository<ParentEntity, Long>, ParentRepo {
}
