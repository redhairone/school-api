package com.ciesielski.schoolapi.domain.model;

import com.ciesielski.schoolapi.infrastructure.entities.ChildEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Attendance {
    private Long id;
    private LocalDateTime entry_date;
    private LocalDateTime exit_date;
    private ChildEntity child_id;
}
