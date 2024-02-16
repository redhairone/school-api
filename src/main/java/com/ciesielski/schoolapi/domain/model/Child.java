package com.ciesielski.schoolapi.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Child {
    private Long id;
    private String firstname;
    private String lastname;
    private Parent parent;
    private School school;
}
