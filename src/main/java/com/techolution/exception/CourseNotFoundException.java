package com.techolution.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {
        super("There is no course registered with id: " + id);
    }

    public CourseNotFoundException(String message) {
        super(message);
    }
}
