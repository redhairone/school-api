package com.ciesielski.schoolapi.infrastructure.entities.mapper;

import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.infrastructure.entities.ChildEntity;

public class ChildMapper {
    public static Child map(ChildEntity input) {
        return Child.builder()
                .id(input.getId())
                .firstname(input.getFirstName())
                .lastname(input.getLastName())
                .parent(ParentMapper.map(input.getParent()))
                .school(SchoolMapper.map(input.getSchool()))
                .build();
    }
}
