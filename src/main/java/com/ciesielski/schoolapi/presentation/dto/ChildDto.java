package com.ciesielski.schoolapi.presentation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChildDto {
    private Long id;
    private String firstname;
    private String lastname;
}
