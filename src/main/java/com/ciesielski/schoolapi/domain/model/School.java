package com.ciesielski.schoolapi.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@RequiredArgsConstructor
public class School {
    private final Long id;
    private final String name;
    private final BigDecimal hourPrice;
}
