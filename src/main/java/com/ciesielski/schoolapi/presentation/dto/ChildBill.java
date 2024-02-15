package com.ciesielski.schoolapi.presentation.dto;

import com.ciesielski.schoolapi.infrastructure.entities.ChildEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChildBill {
    private ChildEntity child;
    private Double cost;
    private Long school_time_in_seconds;
}
