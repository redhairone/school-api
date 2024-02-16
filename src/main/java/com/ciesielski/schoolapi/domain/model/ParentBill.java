package com.ciesielski.schoolapi.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParentBill {
    private Parent parent;
    private Double fullCost;
    private List<ChildBill> childrenBills;
}
