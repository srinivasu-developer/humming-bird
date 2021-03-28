package com.techolution.util;

import com.techolution.entities.*;
import com.techolution.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class QueryRunner implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student("Srinivas", "N", "898989");
        Student student2 = new Student("Srinivas", "N", "898989");
        List<Student> students = Arrays.asList(student1, student2);
        studentRepository.saveAll(students);

        Course course1 = new Course("CE", 1, 10L, "OS");
        Course course2 = new Course("BE", 1, 30L, "course2");
        Course course3 = new Course("CE", 1, 30L, "course3");
        List<Course> courses = Arrays.asList(course1, course2, course3);
        courseRepository.saveAll(courses);

        CourseStudent courseStudent = new CourseStudent(new CourseStudentKey(), student1, course1);
        CourseStudent courseStudent2 = new CourseStudent(new CourseStudentKey(), student1, course2);
        CourseStudent courseStudent3 = new CourseStudent(new CourseStudentKey(), student2, course1);
        CourseStudent courseStudent4 = new CourseStudent(new CourseStudentKey(), student2, course3);
        List<CourseStudent> courseStudents = Arrays.asList(courseStudent, courseStudent2, courseStudent3, courseStudent4);
        studentCourseRepository.saveAll(courseStudents);

        Instructor instructor = new Instructor("CE", "Me", "Paul", "Gov", "9897878");
        instructorRepository.save(instructor);

        Department department = new Department("CE", "HYD");
        Department department2 = new Department("BE", "HYD");
        List<Department> departments = Arrays.asList(department, department2);
        departmentRepository.saveAll(departments);
    }
}
