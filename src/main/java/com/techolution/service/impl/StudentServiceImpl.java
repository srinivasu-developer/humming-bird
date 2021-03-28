package com.techolution.service.impl;

import com.techolution.entities.Course;
import com.techolution.entities.CourseStudent;
import com.techolution.entities.Student;
import com.techolution.exception.StudentNotFoundException;
import com.techolution.repositories.StudentRepository;
import com.techolution.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Course> fetchCoursesForStudent(Long studentId) throws StudentNotFoundException {
        return fetchStudent(studentId).getCourseStudents().stream().map(CourseStudent::getCourse).collect(Collectors.toList());
    }

    @Override
    public Student fetchStudent(Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
    }


}
