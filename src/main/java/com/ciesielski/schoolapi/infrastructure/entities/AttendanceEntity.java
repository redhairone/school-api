package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "attendance")
@Data
public class AttendanceEntity {
    @Id
    private Long id;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    @ManyToOne
    @JoinColumn(name = "child_id")
    private ChildEntity child;
}
