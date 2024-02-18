package com.ciesielski.schoolapi.domain.model;

import com.ciesielski.schoolapi.domain.exceptions.AttendanceDateError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

class AttendanceTest {

    public static Stream<Arguments> provideCalculateNumberOfPayedHours() {
        return Stream.of(
                Arguments.of(LocalTime.of(6, 5), LocalTime.of(9, 50), 1L),
                Arguments.of(LocalTime.of(7, 5), LocalTime.of(9, 50), 0L),
                Arguments.of(LocalTime.of(3, 0), LocalTime.of(6, 30), 4L),
                Arguments.of(LocalTime.of(4, 5), LocalTime.of(6, 0), 2L),
                Arguments.of(LocalTime.of(7, 50), LocalTime.of(14, 30), 3L),
                Arguments.of(LocalTime.of(15, 24), LocalTime.of(23, 32), 9L)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCalculateNumberOfPayedHours")
    void calculateNumberOfPayedHoursTest(final LocalTime startTime, final LocalTime endTime, final Long expected) {
        //GIVEN:
        final Attendance attendance = new Attendance(
                0L,
                LocalDateTime.of(LocalDate.now(), startTime),
                LocalDateTime.of(LocalDate.now(), endTime),
                Mockito.mock(Child.class)
        );

        //WHEN/THEN
        Assertions.assertEquals(expected, attendance.calculateNumberOfPayedHours());
    }

    @Test
    void attendanceConstructorTest_differentDays() {
        //WHEN/THEN
        Assertions.assertThrows(
                AttendanceDateError.class,
                () -> new Attendance(
                        0L,
                        LocalDateTime.of(LocalDate.now(), LocalTime.of(1, 1)),
                        LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(1, 1)),
                        Mockito.mock(Child.class)
                )
        );
    }

    @Test
    void attendanceConstructorTest_entryAfterExit() {
        //GIVEN:
        final LocalDateTime entryDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(2, 2));
        final LocalDateTime exitDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(1, 1));

        //WHEN/THEN
        Assertions.assertThrows(
                AttendanceDateError.class,
                () -> new Attendance(
                        0L,
                        entryDate,
                        exitDate,
                        Mockito.mock(Child.class)
                )
        );
    }
}