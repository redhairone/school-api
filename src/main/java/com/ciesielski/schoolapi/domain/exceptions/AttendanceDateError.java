package com.ciesielski.schoolapi.domain.exceptions;

import java.time.LocalDateTime;

public class AttendanceDateError extends RuntimeException {
    private AttendanceDateError(String message) {
        super(message);
    }

    public static AttendanceDateError entryAfterExitError(final LocalDateTime entryDate, final LocalDateTime exitDate) {
        return new AttendanceDateError(
                String.format("Exit date (%t) cannot be set to after the entry date (%t)", exitDate, entryDate)
        );
    }

    public static AttendanceDateError entryAndExitNotOnTheSameDayError(final LocalDateTime entryDate, final LocalDateTime exitDate) {
        return new AttendanceDateError(
                String.format("Entry (%t) and exit (%t) dates must happen on the same day", entryDate, exitDate)
        );
    }
}
