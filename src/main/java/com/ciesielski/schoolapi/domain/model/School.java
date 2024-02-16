package com.ciesielski.schoolapi.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class School {
    private Long id;
    private String name;
    private BigDecimal hour_price; // todo: precision 2
}
