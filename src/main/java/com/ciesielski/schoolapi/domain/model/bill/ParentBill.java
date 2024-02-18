package com.ciesielski.schoolapi.domain.model.bill;

import com.ciesielski.schoolapi.domain.model.Parent;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ParentBill {
    private final Parent parent;
    private final List<ChildBill> childrenBills;
    private final BigDecimal parentCost;

    public static List<ParentBill> createParentBills(final List<ChildBill> childrenBills) {
        return childrenBills.stream()
                .collect(Collectors.groupingBy(e -> e.getChild().getParent()))
                .entrySet().stream()
                .map(childBillByParent -> createParentBill(childBillByParent.getKey(), childBillByParent.getValue()))
                .toList();
    }

    public static ParentBill createParentBill(final Parent parent, final List<ChildBill> childrenBills) {
        return new ParentBill(
                parent,
                childrenBills,
                calculateFullCost(childrenBills)
        );
    }

    private static BigDecimal calculateFullCost(List<ChildBill> childrenBills) {
        return childrenBills.stream()
                .map(ChildBill::getChildCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
