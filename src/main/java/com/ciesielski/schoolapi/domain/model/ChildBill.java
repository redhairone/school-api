package com.ciesielski.schoolapi.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ChildBill {
    private final Child child;
    private final long numberOfPaidHours;
    private final BigDecimal cost;

    public static ChildBill createChildBill(final Child child, final Collection<Attendance> attendances) {
        long numberOfPaidHours = ChildBill.sumNumberOfPaidHours(attendances);
        return new ChildBill(
                child,
                numberOfPaidHours,
                ChildBill.calculateCostOfAllChildAttendances(child, numberOfPaidHours)
        );
    }

    private static BigDecimal calculateCostOfAllChildAttendances(Child child, long numberOfPaidHours) {
        return child.getSchool().getHour_price()
                .multiply(BigDecimal.valueOf(numberOfPaidHours));
    }

    private static Long sumNumberOfPaidHours(Collection<Attendance> attendances) {
        return attendances.stream()
                .map(Attendance::calculateNumberOfPayedHours)
                .reduce(0L, Long::sum);
    }
}
