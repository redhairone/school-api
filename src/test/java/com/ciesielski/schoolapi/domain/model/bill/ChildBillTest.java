package com.ciesielski.schoolapi.domain.model.bill;

import com.ciesielski.schoolapi.domain.exceptions.bill.ChildBillException;
import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.domain.model.School;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


class ChildBillTest {

    public static Stream<Arguments> provideChildCostCalculationsTest() {
        return Stream.of(
                Arguments.of(0L, 3L, 5L, BigDecimal.valueOf(10), 8L, BigDecimal.valueOf(80)),
                Arguments.of(1L, 2L, 3L, BigDecimal.valueOf(15.2), 6L, BigDecimal.valueOf(91.2)),
                Arguments.of(2L, 1L, 4L, BigDecimal.valueOf(1.32), 7L, BigDecimal.valueOf(9.24)),
                Arguments.of(1L, 1L, 1L, BigDecimal.valueOf(4.15), 3L, BigDecimal.valueOf(12.45))
        );
    }

    @ParameterizedTest
    @MethodSource("provideChildCostCalculationsTest")
    void childCostCalculationsTest(final long firstNumberOfPaidHours,
                                   final long secondNumberOfPaidHours,
                                   final long thirdNumberOfPaidHours,
                                   final BigDecimal costPerHour,
                                   final long expectedHoursSum,
                                   final BigDecimal expectedFullCost) throws ChildBillException {
        // GIVEN:
        final School school = new School(0L, "", costPerHour);
        final Child child = new Child(0L, "", "", null, school);

        List<Attendance> attendances = List.of(
                mockAttendance(child, firstNumberOfPaidHours),
                mockAttendance(child, secondNumberOfPaidHours),
                mockAttendance(child, thirdNumberOfPaidHours)
        );

        // WHEN:
        List<ChildBill> childBills = ChildBill.createChildBills(attendances);

        // THEN:
        Assertions.assertEquals(expectedHoursSum, childBills.get(0).getNumberOfPaidHours());
        Assertions.assertEquals(expectedFullCost, childBills.get(0).getChildCost());
    }

    @Test
    void childBillFromEmptyAttendancesTest() {
        // WHEN/THEN:
        Assertions.assertThrows(
                ChildBillException.class,
                () -> ChildBill.createChildBills(Collections.emptyList())
        );
    }

    private Attendance mockAttendance(final Child child, final long numberOfPaidHours) {
        final Attendance attendance = Mockito.mock(Attendance.class);
        Mockito.when(attendance.calculateNumberOfPayedHours()).thenReturn(numberOfPaidHours);
        Mockito.when(attendance.getChild()).thenReturn(child);
        return attendance;
    }
}