package com.ciesielski.schoolapi.domain.model.bill;

import com.ciesielski.schoolapi.domain.exceptions.bill.ParentBillException;
import com.ciesielski.schoolapi.domain.model.Parent;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ParentBill {
    private final Parent parent;
    private final List<ChildBill> childrenBills;
    private final BigDecimal parentCost;

    public static List<ParentBill> createParentBills(final List<ChildBill> childrenBills) throws ParentBillException {
        checkIfChildrenBillsEmpty(childrenBills);
        return childrenBills.stream()
                .collect(Collectors.groupingBy(e -> e.getChild().getParent()))
                .entrySet().stream()
                .map(es -> new ParentBill(es.getKey(), es.getValue(), calculateFullCost(es.getValue())))
                .toList();
    }

    public static ParentBill createEmptyParentBill(final Parent parent) {
        return new ParentBill(
                parent,
                Collections.emptyList(),
                BigDecimal.valueOf(0)
        );
    }

    private static BigDecimal calculateFullCost(List<ChildBill> childrenBills) {
        return childrenBills.stream()
                .map(ChildBill::getChildCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static void checkIfChildrenBillsEmpty(final List<ChildBill> childrenBills) throws ParentBillException {
        if(childrenBills.isEmpty()) throw new ParentBillException();
    }
}
