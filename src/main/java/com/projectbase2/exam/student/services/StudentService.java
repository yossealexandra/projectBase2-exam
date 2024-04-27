package com.projectbase2.exam.student.services;


import com.projectbase2.exam.student.entities.Student;
import com.projectbase2.exam.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //This gets a list of all students in DataBase
    public ArrayList<Student> getAllStudents(){
        return (ArrayList<Student>) studentRepository.findAll();
    }

    //Gets the info from a student by Id
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    //Register a student in Database
    public ResponseEntity<Object> registerStudent(Student student){
        Optional<Student> res = studentRepository.findStudentByEmail(student.getEmail());
        HashMap<String, Object> map = new HashMap<>();

        if(res.isPresent()){
            map.put("error", true);
            map.put("message:", "Ya existe un estudiante con el email " + student.getEmail());
            return new ResponseEntity<>(map, HttpStatus.CONFLICT);
        }
        studentRepository.save(student);
        map.put("data", student);
        map.put("message:", "Se guardó correctamente la información del estudiante");
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Update a register of a student in DB
    public ResponseEntity<Object> updateStudentById(Student student, Long id) {
        Optional<Student> res = studentRepository.findById(id);
        HashMap<String, Object> map = new HashMap<>();

        if(res.isPresent()){
            student.setId(id);
            studentRepository.save(student);
            map.put("data", student);
            map.put("message:", "Se modificó correctamente la información del estudiante");
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        }
        map.put("error", true);
        map.put("message:", "NO existe un estudiante con el id " + id);
        return new ResponseEntity<>(map, HttpStatus.CONFLICT);

    }

    //Delete a register of a student in DB
    public ResponseEntity<Object> deleteStudentById(Long id) {
        boolean existStudent = this.studentRepository.existsById(id);
        HashMap<String, Object> map = new HashMap<>();

        if(!existStudent){
            map.put("error", true);
            map.put("message:", "NO existe un estudiante con el id " + id);
            return new ResponseEntity<>(map, HttpStatus.CONFLICT);
        }
        studentRepository.deleteById(id);
        map.put("message:", "Se eliminó data de estudiante con el id " + id);
        return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
    }



}
