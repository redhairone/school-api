package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class SchoolEntity {
    @Id
    private Long id;
    private String name;
    private BigDecimal hourPrice;
}
