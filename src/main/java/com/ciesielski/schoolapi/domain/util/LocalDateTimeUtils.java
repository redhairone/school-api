package com.ciesielski.schoolapi.domain.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateTimeUtils {
    public static final LocalTime SEVEN_AM = LocalTime.of(7, 0);
    public static final LocalTime TWELVE_PM = LocalTime.of(12, 0);
    private static final LocalTime MIDNIGHT = LocalTime.of(0, 0);

    public static LocalDateTime createStartOfChosenMonth(int month) {
        return LocalDateTime.of(
                LocalDate.now().withMonth(month).withDayOfMonth(1),
                MIDNIGHT
        );
    }
}
