package com.ciesielski.schoolapi.domain.model.bill;

import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.domain.model.Child;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ChildBill {
    private final Child child;
    private final long numberOfPaidHours;
    private final BigDecimal childCost;

    public static List<ChildBill> createChildBills(final List<Attendance> attendances) {
        return attendances.stream()
                .collect(Collectors.groupingBy(Attendance::getChild))
                .entrySet().stream()
                .map(entrySet -> createChildBill(entrySet.getKey(), entrySet.getValue()))
                .toList();
    }

    public static ChildBill createChildBill(final Child child, final Collection<Attendance> attendances) {
        long numberOfPaidHours = ChildBill.sumNumberOfPaidHours(attendances);
        return new ChildBill(
                child,
                numberOfPaidHours,
                ChildBill.calculateCostOfAllChildAttendances(child, numberOfPaidHours)
        );
    }

    private static BigDecimal calculateCostOfAllChildAttendances(Child child, long numberOfPaidHours) {
        return child.getSchool().getHourPrice()
                .multiply(BigDecimal.valueOf(numberOfPaidHours));
    }

    private static Long sumNumberOfPaidHours(Collection<Attendance> attendances) {
        return attendances.stream()
                .map(Attendance::calculateNumberOfPayedHours)
                .reduce(0L, Long::sum);
    }
}
