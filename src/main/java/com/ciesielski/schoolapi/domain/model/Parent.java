package com.ciesielski.schoolapi.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Parent {
    private Long id;
    private String firstname;
    private String lastname;
}
