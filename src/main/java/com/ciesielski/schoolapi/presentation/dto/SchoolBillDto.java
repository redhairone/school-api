package com.ciesielski.schoolapi.presentation.dto;

import com.ciesielski.schoolapi.domain.model.School;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class SchoolBillDto {
    private final School school;
    private final BigDecimal fullProfit;
    private final List<ParentBillDto> parentBills;
}
