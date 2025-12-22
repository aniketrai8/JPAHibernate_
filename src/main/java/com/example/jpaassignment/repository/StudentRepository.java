package com.example.jpaassignment.repository;

import com.example.jpaassignment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long>{

}