package com.techolution.controllers;

import com.techolution.entities.Instructor;
import com.techolution.entities.Student;
import com.techolution.repositories.InstructorRepository;
import com.techolution.service.InstructorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@Api(value = "Student", description = "Instructor controller to handle all instructor related operations")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private InstructorRepository instructorRepository;

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

    @ApiOperation(value = "View a list of all instructors", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
    }
    )
    @GetMapping
    List<Instructor> fetchAllInstructors() {
        return instructorRepository.findAll();
    }

    @ApiOperation(value = "View instructor for the instructor ID provided", response = Instructor.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved instructor"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The instructor ID you were trying to reach is not found")
    }
    )
    @GetMapping("/instructors/{instructorId}")
    ResponseEntity<Instructor> fetchInstructorById(@NotNull @PathVariable Long instructorId) {
        return ResponseEntity.ok(instructorService.findInstructorById(instructorId));
    }

    @ApiOperation(value = "View instructor for the instructor ID provided", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved instructor"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The instructor ID you were trying to reach is not found")
    }
    )
    @DeleteMapping("/instructors/{instructorId}")
    ResponseEntity<Void> deleteInstructorById(@NotNull @PathVariable Long instructorId) {
        /* Finds instructor with ID if the instructor is not there, it throws exception */
        instructorService.findInstructorById(instructorId);
        instructorRepository.deleteById(instructorId);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Update instructor for the instructor ID provided", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated instructor"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The instructor ID you were trying to reach is not found")
    }
    )
    @PutMapping("/instructors/{instructorId}")
    ResponseEntity<Object> updateInstructor(@NotNull @RequestBody Instructor instructor, @PathVariable long instructorId) {
        /* Finds instructor with ID if the instructor is not there, it throws exception */
        instructorService.findInstructorById(instructorId);
        instructor.setId(instructorId);
        instructorRepository.save(instructor);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Create instructor", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created instructor"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The instructor ID you were trying to reach is not found")
    }
    )
    @PostMapping("/instructors")
    public ResponseEntity<Object> createUser(@NotNull @RequestBody Instructor instructor) {
        Instructor instructorSaved = instructorRepository.save(instructor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(instructorSaved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
