package com.example.jpaassignment.service;

import com.example.jpaassignment.model.Profile;
import com.example.jpaassignment.model.Student;
import com.example.jpaassignment.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import java.util.*;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student createStudentWithProfile(String name,String phone) {
        Student student = new Student(name);

        Profile profile = new Profile(phone);
        student.setProfile(profile);
        return studentRepository.save(student);
    }

        @Transactional(readOnly = true)
        public List<Student> getStudentsWithMoreThanNCourses(long count) {
            return studentRepository.findStudentsWithMoreThanNCourses(count);
        }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student updateStudent(Long id, Student updated) {
        Student existing = getStudent(id);
        existing.setName(updated.getName());
        return studentRepository.save(existing);
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


}
