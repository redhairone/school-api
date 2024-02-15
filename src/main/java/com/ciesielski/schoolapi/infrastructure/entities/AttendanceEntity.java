package com.ciesielski.schoolapi.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class AttendanceEntity {
    @Id
    private Long id;
    private LocalDateTime entry_date;
    private LocalDateTime exit_date;
    @ManyToOne
    @JoinColumn(name = "CHILD_ID")
    private ChildEntity child_id;
}
