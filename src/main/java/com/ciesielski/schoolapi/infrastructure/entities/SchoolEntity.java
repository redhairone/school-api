package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "school")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolEntity {
    @Id
    private Long id;
    private String name;
    private BigDecimal hourPrice;
}
