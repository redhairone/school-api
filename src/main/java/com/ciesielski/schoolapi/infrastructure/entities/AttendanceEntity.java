package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "attendance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceEntity {
    @Id
    private Long id;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    @ManyToOne
    @JoinColumn(name = "child_id")
    private ChildEntity child;
}
