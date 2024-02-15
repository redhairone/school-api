package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ChildEntity {
    @Id
    private Long id;
    private String first_name;
    private String last_name;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private ParentEntity parent_id;
    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private SchoolEntity school_id;
}
