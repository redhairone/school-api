package com.ciesielski.schoolapi.domain.exceptions;

import java.time.LocalDateTime;

public class AttendanceDateError extends RuntimeException {
    private AttendanceDateError(String message) {
        super(message);
    }

    public static AttendanceDateError entryAfterExitError(final LocalDateTime entryDate, final LocalDateTime exitDate) {
        return new AttendanceDateError(
                "Exit date (" + exitDate + ") cannot be set to after the entry date (" + entryDate + ")"
        );
    }

    public static AttendanceDateError entryAndExitNotOnTheSameDayError(final LocalDateTime entryDate, final LocalDateTime exitDate) {
        return new AttendanceDateError(
                "Entry (" + entryDate + ") and exit (" + exitDate + ") dates must happen on the same day"
        );
    }
}
