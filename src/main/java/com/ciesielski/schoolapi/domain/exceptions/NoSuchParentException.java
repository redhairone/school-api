package com.ciesielski.schoolapi.domain.exceptions;

import java.util.NoSuchElementException;

public class NoSuchParentException extends NoSuchElementException {

    public NoSuchParentException(final long id) {
        super("Could not find a parent with given ID: " + id);
    }
}
