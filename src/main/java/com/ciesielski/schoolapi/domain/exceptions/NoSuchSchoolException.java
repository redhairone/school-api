package com.ciesielski.schoolapi.domain.exceptions;

import java.util.NoSuchElementException;

public class NoSuchSchoolException extends NoSuchElementException {

    public NoSuchSchoolException(final long id) {
        super("Could not find a school with ID: " + id);
    }
}
