package com.techolution.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("There is no student registered with id: " + id);
    }

}
