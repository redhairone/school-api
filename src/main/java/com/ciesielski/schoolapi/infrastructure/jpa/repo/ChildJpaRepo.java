package com.ciesielski.schoolapi.infrastructure.jpa.repo;

import com.ciesielski.schoolapi.domain.repo.ChildRepo;
import com.ciesielski.schoolapi.infrastructure.entities.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildJpaRepo extends JpaRepository<ChildEntity, Long>, ChildRepo {
}
