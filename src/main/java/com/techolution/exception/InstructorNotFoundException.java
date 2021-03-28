package com.techolution.exception;

public class InstructorNotFoundException extends RuntimeException {

    public InstructorNotFoundException(Long id) {
        super("There is no instructor registered with id: " + id);
    }

}
