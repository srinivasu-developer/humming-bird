package com.techolution.service.impl;

import com.techolution.entities.Course;
import com.techolution.entities.CourseStudent;
import com.techolution.entities.Instructor;
import com.techolution.entities.Student;
import com.techolution.exception.InstructorNotFoundException;
import com.techolution.repositories.InstructorRepository;
import com.techolution.service.InstructorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Student> findStudentsByInstructor(Long instructorId) {
        log.info(findInstructorById(instructorId).getCourses().toString());
        findInstructorById(instructorId).getCourses().forEach(System.out::println);
        return findInstructorById(instructorId).getCourses().stream().map(Course::getCourseStudents).flatMap(Collection::stream).map(CourseStudent::getStudent).distinct().collect(Collectors.toList());
    }

    @Override
    public Instructor findInstructorById(Long instructorId) {
        return instructorRepository.findById(instructorId).orElseThrow(() -> new InstructorNotFoundException(instructorId));
    }

}
