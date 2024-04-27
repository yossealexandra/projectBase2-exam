package com.projectbase2.exam.student.controllers;


import com.projectbase2.exam.student.entities.Student;
import com.projectbase2.exam.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ArrayList<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id){
        return this.studentService.getStudentById(id);
    }

    @PostMapping
    public ResponseEntity<Object> validateStudent(@RequestBody Student student){
        return this.studentService.registerStudent(student);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateStudentById(@RequestBody Student student, @PathVariable("id") Long id){
        return this.studentService.updateStudentById(student, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteStudentById(@PathVariable("id") Long id){
        return this.studentService.deleteStudentById(id);
    }


}
