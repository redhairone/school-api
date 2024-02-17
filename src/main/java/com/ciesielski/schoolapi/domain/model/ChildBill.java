package com.ciesielski.schoolapi.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;

@Data
public class ChildBill {
    final private Child child;
    private BigDecimal cost;
    private long numberOfPaidHours;

    public ChildBill(final Child child, final Collection<Attendance> attendances) {
        this.child = child;
        this.numberOfPaidHours = attendances.stream()
                .map(Attendance::calculateNumberOfPayedHours)
                .reduce(0L, Long::sum);
        this.cost = child.getSchool().getHour_price().multiply(BigDecimal.valueOf(numberOfPaidHours));
    }
}
