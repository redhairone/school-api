package com.ciesielski.schoolapi.domain.repo;

import com.ciesielski.schoolapi.domain.model.School;

import java.util.Optional;

public interface SchoolRepo {

    Optional<School> findSchoolById(Long id);
}
