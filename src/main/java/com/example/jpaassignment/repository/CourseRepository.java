package com.example.jpaassignment.repository;

import com.example.jpaassignment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}