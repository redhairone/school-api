package com.ciesielski.schoolapi.domain.repo;

import com.ciesielski.schoolapi.domain.model.Parent;

import java.util.Optional;

public interface ParentRepo {
    Optional<Parent> findParentById(Long id);
}
