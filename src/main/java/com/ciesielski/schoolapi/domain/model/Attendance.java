package com.ciesielski.schoolapi.domain.model;

import com.ciesielski.schoolapi.domain.exceptions.AttendanceDateError;
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

    private static final LocalTime SEVEN_AM = LocalTime.of(7, 0);
    private static final LocalTime TWELVE_PM = LocalTime.of(12, 0);

    public Attendance(Long id, LocalDateTime entryDate, LocalDateTime exitDate, Child child) {
        this.id = id;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.child = child;

        if (isEntryAfterExit()) {
            throw new AttendanceDateError("Exit date cannot be set to after the entry date");
        }

        if (isEntryAndExitNotTheSameDay()) {
            throw new AttendanceDateError("Entry and exit dates must happen on the same day");
        }
    }

    public long calculateNumberOfPayedHours() {
        LocalTime startTime = entryDate.toLocalTime();
        LocalTime endTime = exitDate.toLocalTime();
        long numberOfPaidHours = 0;

        if (isItBeforeSevenAm(startTime)) {
            numberOfPaidHours += countHours(
                    startTime,
                    isBeforeOrAtSevenAm(endTime) ? endTime : SEVEN_AM
            );
        }

        if (isItAfterTwelvePm(endTime)) {
            numberOfPaidHours += countHours(
                    isItAfterTwelvePm(startTime) ? startTime : TWELVE_PM,
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
        return time.isBefore(Attendance.SEVEN_AM) || time.equals(Attendance.SEVEN_AM);
    }

    private static boolean isItAfterTwelvePm(LocalTime endTime) {
        return endTime.isAfter(TWELVE_PM);
    }

    private static boolean isItBeforeSevenAm(LocalTime startTime) {
        return startTime.isBefore(SEVEN_AM);
    }
}
