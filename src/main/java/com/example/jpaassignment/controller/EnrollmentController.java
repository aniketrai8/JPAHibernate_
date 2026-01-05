package com.example.jpaassignment.controller;

import com.example.jpaassignment.model.Enrollment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.jpaassignment.service.EnrollmentService;



@RestController
@RequestMapping("/api/enrollments")

public class EnrollmentController {


    private final EnrollmentService enrollmentService;

    public EnrollmentController( EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Enrollment enroll(
        @RequestParam Long studentId,
        @RequestParam Long courseId
        ){
        return enrollmentService.enrollmentStudent(studentId,courseId);

    }


}
