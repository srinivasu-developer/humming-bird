package com.techolution.controllers;

import com.techolution.entities.Student;
import com.techolution.service.InstructorService;
import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Student", description = "Instructor controller to handle all instructor related operations")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @ApiOperation(value = "View a list of all students for the provided instructor ID", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The instructor ID you were trying to reach is not found")
    }
    )
    @GetMapping("/instructors/{instructorId}/students")
    List<Student> fetchStudentsForInstructor(@NotNull @PathVariable Long instructorId) {
        return instructorService.findStudentsByInstructor(instructorId);
    }
}
