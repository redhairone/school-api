package com.ciesielski.schoolapi.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class Child {
    private final Long id;
    private final String firstname;
    private final String lastname;
    private final Parent parent;
    private final School school;
}
