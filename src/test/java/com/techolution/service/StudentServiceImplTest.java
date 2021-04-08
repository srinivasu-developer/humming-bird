package com.techolution.service;

import com.techolution.entities.Student;
import com.techolution.exception.StudentNotFoundException;
import com.techolution.repositories.StudentRepository;
import com.techolution.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    void initUseCase() {
        studentService = new StudentServiceImpl(studentRepository);
    }

    /**
     * Test case for getting student
     */
    @Test
    void fetchStudent_WithStudent() {
        Student student = new Student();
        when(studentRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(student));
        Student student1 = studentService.fetchStudent(1L);
        assertThat(student1).isNotNull();
    }

    /**
     * Test case if student not found
     */
    @Test
    void fetchStudent_WithoutStudent() {
        when(studentRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());
        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            studentService.fetchStudent(1L);
        });
    }
}