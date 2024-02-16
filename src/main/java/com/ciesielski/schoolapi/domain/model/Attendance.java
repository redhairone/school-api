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

        if (entryDate.isAfter(exitDate)) {
            throw new AttendanceDateError("Exit date cannot be set to after the entry date");
        }

        if (isEntryAndExitNotTheSameDay()) {
            throw new AttendanceDateError("Entry and exit dates must happen on the same day");
        }
    }

    private boolean isEntryAndExitNotTheSameDay() {
        return !entryDate.toLocalDate().equals(exitDate.toLocalDate());
    }

    public long calculateNumberOfPayedHours() {
        LocalTime startTime = entryDate.toLocalTime();
        LocalTime endTime = exitDate.toLocalTime();
        long numberOfPaidHours = 0;

        // Count hours before 7AM
        if (startTime.isBefore(SEVEN_AM)) {
            numberOfPaidHours += countHours(
                    startTime,
                    isBeforeOrAt(endTime, SEVEN_AM) ? endTime : SEVEN_AM
            );
        }

        // Count hours after 12PM
        if (endTime.isAfter(TWELVE_PM)) {
            numberOfPaidHours += countHours(
                    startTime.isAfter(TWELVE_PM) ? startTime : TWELVE_PM,
                    endTime
            );
        }

        return numberOfPaidHours;
    }

    // WORKS
    private long countHours(LocalTime startTime, LocalTime endTime) {
        if (startTime.getHour() == endTime.getHour()) return 1;

        LocalTime startTimeWithoutMinute = startTime.withMinute(0);
        long result = ChronoUnit.HOURS.between(startTimeWithoutMinute, endTime);

        if (endTime.getMinute() == 0) return result;
        return result + 1;
    }

    private boolean isBeforeOrAt(LocalTime time, LocalTime comparator) {
        return time.isBefore(comparator) || time.equals(comparator);
    }
}
