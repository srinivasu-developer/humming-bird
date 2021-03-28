package com.techolution.controllers;

import com.techolution.entities.Course;
import com.techolution.repositories.StudentRepository;
import com.techolution.service.StudentService;
import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Api(value = "Student", description = "Student controller to handle all student related operations")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "View a list of all courses for the provided student ID", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The student ID you were trying to reach is not found")
    }
    )
    @GetMapping("/students/{studentId}/courses")
    List<Course> fetchCoursesForStudent(@NotNull @PathVariable Long studentId) {
        return studentService.fetchCoursesForStudent(studentId);
    }

    @ApiOperation(value = "The total amount of duration all the courses for the student ID provided", response = Long.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the duration"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The student with ID you were trying to reach is not found")
    }
    )
    @GetMapping("/students/{studentId}/course-duration")
    Long fetchCourseDurationForStudent(@PathVariable Long studentId) {
        return studentService.fetchCoursesForStudent(studentId).stream().mapToLong(Course::getDuration).sum();
    }
}
