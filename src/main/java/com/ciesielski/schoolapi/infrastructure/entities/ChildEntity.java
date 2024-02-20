package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "child")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildEntity {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne()
    @JoinColumn(name = "parent_id")
    private ParentEntity parent;
    @ManyToOne()
    @JoinColumn(name = "school_id")
    private SchoolEntity school;
}
