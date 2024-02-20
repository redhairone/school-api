package com.ciesielski.schoolapi.domain.model.bill;

import com.ciesielski.schoolapi.domain.exceptions.bill.SchoolBillException;
import com.ciesielski.schoolapi.domain.model.School;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SchoolBill {
    private final School school;
    private final List<ParentBill> parentBills;
    private final BigDecimal schoolProfit;

    public static SchoolBill createSchoolBill(final List<ParentBill> parentBills) throws SchoolBillException {
        checkIfParentBillsEmpty(parentBills);
        return new SchoolBill(
                getSchoolFromParentBills(parentBills),
                parentBills,
                calculateFullCost(parentBills)
        );
    }

    public static SchoolBill createEmptySchoolBill(final School school) {
        return new SchoolBill(
                school,
                Collections.emptyList(),
                BigDecimal.ZERO
        );
    }

    private static BigDecimal calculateFullCost(List<ParentBill> parentBills) {
        return parentBills.stream()
                .map(ParentBill::getParentCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static void checkIfParentBillsEmpty(List<ParentBill> parentBills) throws SchoolBillException {
        if (parentBills.isEmpty()) {
            throw new SchoolBillException();
        }
    }

    private static School getSchoolFromParentBills(List<ParentBill> parentBills) {
        return parentBills.get(0).getChildrenBills().get(0).getChild().getSchool();
    }

}
