package com.ciesielski.schoolapi.presentation.dto.mapper;

import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.presentation.dto.ChildDto;

public class ChildDtoMapper {
    public static ChildDto map(Child input) {
        return ChildDto.builder()
                .id(input.getId())
                .firstname(input.getFirstname())
                .lastname(input.getLastname())
                .build();
    }
}
