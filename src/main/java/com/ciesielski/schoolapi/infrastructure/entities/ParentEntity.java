package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "parent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentEntity {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
