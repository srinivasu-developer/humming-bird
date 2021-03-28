package com.techolution.service;

import com.techolution.entities.Instructor;
import com.techolution.entities.Student;
import com.techolution.exception.InstructorNotFoundException;

import java.util.List;

public interface InstructorService {

    /**
     * Finds students under the instructor for the instructor ID
     *
     * @param instructorId the instructor ID to provide students
     * @return list of Student for the instructor
     * @throws InstructorNotFoundException if there is no instructor for the ID provided
     */
    List<Student> findStudentsByInstructor(Long instructorId) throws InstructorNotFoundException;

    /**
     * Finds instructor by ID provided
     *
     * @param instructorId the instructor ID
     * @return Instructor for the id provided
     * @throws InstructorNotFoundException if there is no instructor for the ID provided
     */
    Instructor findInstructorById(Long instructorId) throws InstructorNotFoundException;
}
