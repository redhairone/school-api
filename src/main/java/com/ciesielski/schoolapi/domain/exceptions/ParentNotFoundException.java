package com.ciesielski.schoolapi.domain.exceptions;

public class ParentNotFoundException extends RuntimeException{

    public ParentNotFoundException(final long id) {
        super("Could not find a parent with given ID: " + id);
    }
}
