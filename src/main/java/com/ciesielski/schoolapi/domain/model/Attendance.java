package com.ciesielski.schoolapi.domain.model;

import com.ciesielski.schoolapi.domain.exceptions.AttendanceDateError;
import com.ciesielski.schoolapi.domain.util.LocalDateTimeUtils;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Data
public class Attendance {
    private Long id;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Child child;

    public Attendance(Long id, LocalDateTime entryDate, LocalDateTime exitDate, Child child) {
        this.id = id;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.child = child;

        if (isEntryAfterExit()) {
            throw AttendanceDateError.entryAfterExitError(entryDate, exitDate);
        }

        if (isEntryAndExitNotTheSameDay()) {
            throw AttendanceDateError.entryAndExitNotOnTheSameDayError(entryDate, exitDate);
        }
    }

    public long calculateNumberOfPayedHours() {
        LocalTime startTime = entryDate.toLocalTime();
        LocalTime endTime = exitDate.toLocalTime();
        long numberOfPaidHours = 0;

        if (isBeforeSevenAm(startTime)) {
            numberOfPaidHours += countHours(
                    startTime,
                    isBeforeOrAtSevenAm(endTime) ? endTime : LocalDateTimeUtils.SEVEN_AM
            );
        }

        if (isAfterTwelvePm(endTime)) {
            numberOfPaidHours += countHours(
                    isAfterTwelvePm(startTime) ? startTime : LocalDateTimeUtils.TWELVE_PM,
                    endTime
            );
        }

        return numberOfPaidHours;
    }

    private long countHours(LocalTime startTime, LocalTime endTime) {
        if (startTime.getHour() == endTime.getHour()) return 1;

        LocalTime startTimeWithoutMinute = startTime.withMinute(0);
        long result = ChronoUnit.HOURS.between(startTimeWithoutMinute, endTime);

        if (endTime.getMinute() == 0) return result;
        return result + 1;
    }

    private boolean isEntryAndExitNotTheSameDay() {
        return !this.entryDate.toLocalDate().equals(this.exitDate.toLocalDate());
    }

    private boolean isEntryAfterExit() {
        return this.entryDate.isAfter(this.exitDate);
    }

    private boolean isBeforeOrAtSevenAm(LocalTime time) {
        return time.isBefore(LocalDateTimeUtils.SEVEN_AM) || time.equals(LocalDateTimeUtils.SEVEN_AM);
    }

    private static boolean isAfterTwelvePm(LocalTime endTime) {
        return endTime.isAfter(LocalDateTimeUtils.TWELVE_PM);
    }

    private static boolean isBeforeSevenAm(LocalTime startTime) {
        return startTime.isBefore(LocalDateTimeUtils.SEVEN_AM);
    }
}
