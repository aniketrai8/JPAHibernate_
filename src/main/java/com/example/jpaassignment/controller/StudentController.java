package com.example.jpaassignment.controller;

import com.example.jpaassignment.service.StudentService;
import com.example.jpaassignment.model.Student;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;

    }
    @PostMapping
    public Student createStudent(
        @RequestParam String name,
        @RequestParam String phone
    ){
        return studentService.createStudentWithProfile(name,phone);

    }
}
