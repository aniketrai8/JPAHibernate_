package com.example.jpaassignment.controller;

import com.example.jpaassignment.service.StudentService;
import com.example.jpaassignment.model.Student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Student createStudent(
        @RequestParam String name,
        @RequestParam String phone
    ){
        return studentService.createStudentWithProfile(name,phone);

    }

    @GetMapping("/filter/by-course-count")
    public List<Student> studentsWithMoreThanNCourses(
            @RequestParam int count) {
        return studentService.getStudentsWithMoreThanNCourses(count);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }


    @PutMapping("/{id}")
    public Student update(
            @PathVariable Long id,
            @RequestBody Student student
    ) {
        return studentService.updateStudent(id, student);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }


}
