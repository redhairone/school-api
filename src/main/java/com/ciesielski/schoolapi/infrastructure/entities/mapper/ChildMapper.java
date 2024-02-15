package com.ciesielski.schoolapi.infrastructure.entities.mapper;

import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.infrastructure.entities.ChildEntity;

public class ChildMapper implements Mapper<ChildEntity, Child>{
    @Override
    public Child map(ChildEntity input) {
        return Child.builder()
                .id(input.getId())
                .firstname(input.getFirst_name())
                .lastname(input.getLast_name())
                .parent_id(input.getParent_id())
                .school_id(input.getSchool_id())
                .build();
    }
}
