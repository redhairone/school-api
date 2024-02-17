package com.ciesielski.schoolapi.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ParentBill {
    private Parent parent;
    private BigDecimal fullCost;
    private List<ChildBill> childrenBills;

    public ParentBill(final Parent parent, final List<ChildBill> childrenBills) {
        this.parent = parent;
        this.childrenBills = childrenBills;
        this.fullCost = childrenBills.stream()
                .map(ChildBill::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
