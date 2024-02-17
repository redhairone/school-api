package com.ciesielski.schoolapi.presentation.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ChildBillDto {
    final private ChildDto child;
    private BigDecimal cost;
    private long numberOfPaidHours;
}
