package com.ciesielski.schoolapi.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ParentBill {
    private final Parent parent;
    private final List<ChildBill> childrenBills;
    private final BigDecimal fullCost;

    public static ParentBill createParentBill(final Parent parent, final List<ChildBill> childrenBills) {
        return new ParentBill(
                parent,
                childrenBills,
                calculateFullCost(childrenBills)
        );
    }

    private static BigDecimal calculateFullCost(List<ChildBill> childrenBills) {
        return childrenBills.stream()
                .map(ChildBill::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
