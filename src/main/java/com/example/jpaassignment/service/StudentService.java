package com.example.jpaassignment.service;

import com.example.jpaassignment.model.Profile;
import com.example.jpaassignment.model.Student;
import com.example.jpaassignment.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student createStudentWithProfile(String name,String phone){
        Student student = new Student(name);

        Profile profile  = new Profile(phone);
        student.setProfile(profile);



        return studentRepository.save(student);
    }
}
