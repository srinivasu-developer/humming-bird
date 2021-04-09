package com.techolution.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techolution.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = StudentController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
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
        mockMvc.perform(get("/students/{studentId}/courses", 1)
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidInput_thenMapsToBusinessModel() throws Exception {
        mockMvc.perform(get("/students/{studentId}/courses", 1)
                .contentType("application/json"))
                .andExpect(status().isOk());
        Mockito.verify(studentService, times(1)).fetchCoursesForStudent(1L);
    }

    @Test
    void whenValidInput_thenReturnsUserResource() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/students/{studentId}/course-duration", 1)
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        Long expectedResponseBody = 0L;
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        Assertions.assertThat(actualResponseBody).isEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(expectedResponseBody));
    }


}