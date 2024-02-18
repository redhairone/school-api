package com.ciesielski.schoolapi.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;


class ChildBillTest {

    public static Stream<Arguments> provideChildBillConstructorTest() {
        return Stream.of(
                Arguments.of(0L, 3L, 5L, BigDecimal.valueOf(10), 8L, BigDecimal.valueOf(80)),
                Arguments.of(1L, 2L, 3L, BigDecimal.valueOf(15.2), 6L, BigDecimal.valueOf(91.2)),
                Arguments.of(2L, 1L, 4L, BigDecimal.valueOf(1.32), 7L, BigDecimal.valueOf(9.24)),
                Arguments.of(1L, 1L, 1L, BigDecimal.valueOf(4.15), 3L, BigDecimal.valueOf(12.45))
        );
    }

    @ParameterizedTest
    @MethodSource("provideChildBillConstructorTest")
    void childBillConstructorTest(final long firstNumberOfPaidHours,
                                  final long secondNumberOfPaidHours,
                                  final long thirdNumberOfPaidHours,
                                  final BigDecimal costPerHour,
                                  final long expectedHoursSum,
                                  final BigDecimal expectedFullCost) {
        // GIVEN:
        Parent parent = Mockito.mock(Parent.class);
        School school = Mockito.mock(School.class);
        Mockito.when(school.getHour_price()).thenReturn(costPerHour);

        Child child = new Child(0L, "", "", parent, school);

        List<Attendance> attendances = List.of(
                mockAttendance(firstNumberOfPaidHours),
                mockAttendance(secondNumberOfPaidHours),
                mockAttendance(thirdNumberOfPaidHours)
        );

        // WHEN:
        ChildBill childBill = ChildBill.createChildBill(child, attendances);

        // THEN:
        Assertions.assertEquals(child, childBill.getChild());
        Assertions.assertEquals(expectedHoursSum, childBill.getNumberOfPaidHours());
        Assertions.assertEquals(expectedFullCost, childBill.getCost());
    }

    private Attendance mockAttendance(final long numberOfPaidHours) {
        Attendance attendance = Mockito.mock(Attendance.class);
        Mockito.when(attendance.calculateNumberOfPayedHours()).thenReturn(numberOfPaidHours);
        return attendance;
    }
}