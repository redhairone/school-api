package com.ciesielski.schoolapi.domain.repo;

import com.ciesielski.schoolapi.domain.model.Child;

import java.util.List;

public interface ChildRepo {
    List<Child> findAllChildrenByParentId(Long id);
}
