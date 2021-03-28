package com.techolution.service;

import com.techolution.entities.Course;
import com.techolution.entities.Student;
import com.techolution.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    /**
     * Finds the courses for the student ID provided
     *
     * @param studentId the student ID to find courses
     * @return list of {@Class Course}, sends empty list if there are no courses for student
     * @throws StudentNotFoundException if student is not found with the provided student ID
     */
    List<Course> fetchCoursesForStudent(Long studentId) throws StudentNotFoundException;

    /**
     * Finds student for the provided student ID
     *
     * @param studentId the student ID to find student
     * @return returns {@Class Student} if found one with the student ID
     * @throws StudentNotFoundException if there is no student for the ID provided
     */
    Student fetchStudent(Long studentId) throws StudentNotFoundException;

}
