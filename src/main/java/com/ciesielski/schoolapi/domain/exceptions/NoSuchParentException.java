package com.ciesielski.schoolapi.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchParentException extends NoSuchElementException {

    public NoSuchParentException(final long id) {
        super("Could not find a parent with given ID: " + id);
    }
}
