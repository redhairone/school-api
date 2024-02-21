package com.ciesielski.schoolapi.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchSchoolException extends NoSuchElementException {
    public NoSuchSchoolException(final long id) {
        super("Could not find a school with ID: " + id);
    }
}
