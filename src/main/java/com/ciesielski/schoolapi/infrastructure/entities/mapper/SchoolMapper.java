package com.ciesielski.schoolapi.infrastructure.entities.mapper;

import com.ciesielski.schoolapi.domain.model.School;
import com.ciesielski.schoolapi.infrastructure.entities.SchoolEntity;

public class SchoolMapper {
    public static School map(SchoolEntity input) {
        return School.builder()
                .id(input.getId())
                .name(input.getName())
                .hour_price(input.getHourPrice())
                .build();
    }
}
