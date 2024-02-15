package com.ciesielski.schoolapi.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class School {
    private Long id;
    private String name;
    private double hour_price;
}
