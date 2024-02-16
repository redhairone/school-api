package com.ciesielski.schoolapi.infrastructure.entities.mapper;

import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.infrastructure.entities.ChildEntity;

public class ChildMapper implements Mapper<ChildEntity, Child>{
    @Override
    public Child map(ChildEntity input) {
        ParentMapper parentMapper = new ParentMapper();
        SchoolMapper schoolMapper = new SchoolMapper();

        return Child.builder()
                .id(input.getId())
                .firstname(input.getFirstName())
                .lastname(input.getLastName())
                .parent(parentMapper.map(input.getParent()))
                .school(schoolMapper.map(input.getSchool()))
                .build();
    }
}
