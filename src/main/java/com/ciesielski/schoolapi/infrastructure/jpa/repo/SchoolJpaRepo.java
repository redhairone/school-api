package com.ciesielski.schoolapi.infrastructure.jpa.repo;

import com.ciesielski.schoolapi.domain.model.School;
import com.ciesielski.schoolapi.domain.repo.SchoolRepo;
import com.ciesielski.schoolapi.infrastructure.entities.SchoolEntity;
import com.ciesielski.schoolapi.infrastructure.entities.mapper.SchoolMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolJpaRepo extends JpaRepository<SchoolEntity, Long>, SchoolRepo {

    default Optional<School> findSchoolById(Long id) {
        final SchoolMapper schoolMapper = new SchoolMapper();
        return this.findById(id).map(schoolMapper::map);
    };
}
