package com.ciesielski.schoolapi.domain.model;

import com.ciesielski.schoolapi.infrastructure.entities.ParentEntity;
import com.ciesielski.schoolapi.infrastructure.entities.SchoolEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Child {
    private Long id;
    private String firstname;
    private String lastname;
    private ParentEntity parent_id;
    private SchoolEntity school_id;
}
