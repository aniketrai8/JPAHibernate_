package com.example.jpaassignment.service;
import com.example.jpaassignment.model.Course;
import com.example.jpaassignment.model.Enrollment;
import com.example.jpaassignment.model.Student;
import com.example.jpaassignment.repository.CourseRepository;
import com.example.jpaassignment.repository.EnrollmentRepository;
import com.example.jpaassignment.repository.StudentRepository;
import jakarta.transaction.Transactional;
import java.util.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;


@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(
            EnrollmentRepository enrollmentRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository
    ) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public Enrollment enrollmentStudent(Long studentId, Long courseId){

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("student not found"));

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("course not Found"));

        Enrollment enrollment = new Enrollment(student,course);
        return enrollmentRepository.save(enrollment);


    }


}
