package com.techolution.service;

import com.techolution.entities.Instructor;
import com.techolution.entities.Student;
import com.techolution.exception.InstructorNotFoundException;
import com.techolution.exception.StudentNotFoundException;
import com.techolution.repositories.InstructorRepository;
import com.techolution.service.impl.InstructorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstructorServiceImplTest {

    @Mock
    private InstructorRepository instructorRepository;

    private InstructorService instructorService;

    @BeforeEach
    void initUseCase() {
        instructorService = new InstructorServiceImpl(instructorRepository);
    }

    @Test
    void findInstructorById() {
        Instructor instructor = new Instructor();
        when(instructorRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(instructor));
        Instructor instructorById = instructorService.findInstructorById(1L);
        assertThat(instructorById).isNotNull();
    }

    @Test
    void fetchStudent_WithoutInstructor() {
        when(instructorRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());
        Assertions.assertThrows(InstructorNotFoundException.class, () -> {
            instructorService.findInstructorById(1L);
        });
    }
}