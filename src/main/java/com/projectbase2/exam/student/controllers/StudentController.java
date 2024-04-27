package com.projectbase2.exam.student.controllers;


import com.projectbase2.exam.student.entities.Student;
import com.projectbase2.exam.student.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Tag(name= "Students resource")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Operation(summary = "Get a list of recorded students in Database")
    @GetMapping
    public ArrayList<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @Operation(summary = "Get a recorded student in Database by a given student id")
    @GetMapping(path = "/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id){
        return this.studentService.getStudentById(id);
    }

    @Operation(summary = "Save a record student in Database by a given Student body data")
    @PostMapping
    public ResponseEntity<Object> validateStudent(@RequestBody Student student){
        return this.studentService.registerStudent(student);
    }

    @Operation(summary = "Update changes in a recorded student in Database by a given student id and a Body Student with these changes")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateStudentById(@RequestBody Student student, @PathVariable("id") Long id){
        return this.studentService.updateStudentById(student, id);
    }

    @Operation(summary = "Delete a recorded student in Database by a given Path variable student id")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteStudentById(@PathVariable("id") Long id){
        return this.studentService.deleteStudentById(id);
    }


}
