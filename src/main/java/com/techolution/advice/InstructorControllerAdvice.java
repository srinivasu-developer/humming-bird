package com.techolution.advice;

import com.techolution.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class InstructorControllerAdvice {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<String> studentNotFound(RuntimeException exception) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
