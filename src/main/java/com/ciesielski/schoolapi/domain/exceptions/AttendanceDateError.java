package com.ciesielski.schoolapi.domain.exceptions;

public class AttendanceDateError extends RuntimeException {
    public AttendanceDateError(String message) {
        super(message);
    }
}
