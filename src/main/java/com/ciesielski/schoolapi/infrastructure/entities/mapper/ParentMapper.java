package com.ciesielski.schoolapi.infrastructure.entities.mapper;

import com.ciesielski.schoolapi.domain.model.Parent;
import com.ciesielski.schoolapi.infrastructure.entities.ParentEntity;

public class ParentMapper implements Mapper<ParentEntity, Parent> {
    @Override
    public Parent map(ParentEntity input) {
        return Parent.builder()
                .id(input.getId())
                .firstname(input.getFirstName())
                .lastname(input.getLastName())
                .build();
    }
}
