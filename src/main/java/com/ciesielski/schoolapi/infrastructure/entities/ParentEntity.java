package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ParentEntity {
    @Id
    private Long id;
    private String first_name;
    private String last_name;
}
