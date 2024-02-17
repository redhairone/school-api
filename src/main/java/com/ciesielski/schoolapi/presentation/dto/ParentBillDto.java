package com.ciesielski.schoolapi.presentation.dto;

import com.ciesielski.schoolapi.domain.model.Parent;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ParentBillDto {
    private Parent parent;
    private BigDecimal fullCost;
    private List<ChildBillDto> childrenBills;
}
