package com.projectbase2.exam.student.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectbase2.exam.student.entities.Student;
import com.projectbase2.exam.student.services.StudentService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    private Student student;

    @BeforeEach
    public void init () {
        student = new Student();
    }

    @Test
    public void getAllStudents() throws Exception {

    }

    @Test
    public void getStudentById() throws Exception {
        // Define the student ID for the test
        Long studentId = 1L;

        // Mocking the service behavior to return an Optional containing a specific Student instance
        when(studentService.getStudentById(studentId)).thenReturn(Optional.of(student));

        // Performing an HTTP GET request to retrieve a student by ID
        ResultActions response = mockMvc.perform(get("/student/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)));

        // Asserting the response expectations
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", CoreMatchers.is(student.getFirstName())))
                .andExpect(jsonPath("$.email", CoreMatchers.is(student.getEmail())));
    }

    @Test
    public void getStudentById_WhenStudentExistsButIsNull() throws Exception {
        // Define the student ID for the test
        Long studentId = 1L;

        // Mocking the service behavior to return an Optional containing a specific Student instance
        when(studentService.getStudentById(studentId)).thenReturn(Optional.of(student));

        // Performing an HTTP GET request to retrieve a student by ID
        ResultActions response = mockMvc.perform(get("/student/1")
                .contentType(MediaType.APPLICATION_JSON));

        // Asserting the response expectations
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").doesNotExist())
                .andExpect(jsonPath("$.email").doesNotExist());
    }


}