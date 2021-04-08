package com.techolution.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techolution.entities.Student;
import com.techolution.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = StudentController.class)
@ActiveProfiles(value = "test")
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    @Test
    void whenValidUrlAndMethodAndContentType_thenReturns200() throws Exception {

        Student student = new Student("test", "test", "7378338");
        student.setId(1L);
        mockMvc.perform(get("/students/{studentId}/courses", 1)
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

}