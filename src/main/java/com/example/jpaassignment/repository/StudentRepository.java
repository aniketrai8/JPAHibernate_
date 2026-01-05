package com.example.jpaassignment.repository;

import com.example.jpaassignment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long>{

    @Query(name = "Student.findWithMoreThanNCourses")
    List<Student> findStudentsWithMoreThanNCourses(@Param("count") long count);
}
