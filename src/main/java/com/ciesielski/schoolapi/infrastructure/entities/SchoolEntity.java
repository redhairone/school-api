package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SchoolEntity {
    @Id
    private Long id;
    private String name;
    private double hour_price;
}
