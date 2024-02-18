package com.ciesielski.schoolapi.domain.model.bill;

import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.domain.model.School;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SchoolBill {
    private final School school;
    private final List<ParentBill> parentBills;
    private final BigDecimal schoolProfit;

    public static SchoolBill createSchoolBills(final School school, final List<Attendance> attendances) {
        final List<ChildBill> childrenBills = ChildBill.createChildBills(attendances);
        final List<ParentBill> parentBills = ParentBill.createParentBills(childrenBills);
        return SchoolBill.createSchoolBill(school, parentBills);
    }

    public static SchoolBill createSchoolBill(final School school, final List<ParentBill> parentBills) {
        return new SchoolBill(
                school,
                parentBills,
                calculateFullCost(parentBills)
        );
    }

    private static BigDecimal calculateFullCost(List<ParentBill> parentBills) {
        return parentBills.stream()
                .map(ParentBill::getParentCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
