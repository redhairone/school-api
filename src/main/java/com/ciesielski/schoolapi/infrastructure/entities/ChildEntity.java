package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "child")
@Data
public class ChildEntity {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ParentEntity parent;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;
}
