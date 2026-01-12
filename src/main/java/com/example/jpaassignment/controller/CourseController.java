package com.example.jpaassignment.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.jpaassignment.service.CourseService;
import com.example.jpaassignment.model.Course;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/courses")
public class CourseController {


    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService= courseService;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/courses")
    public Course createCourse(
        @RequestParam String heading,
        @RequestBody List<String>topics
    ){
        return courseService.createCourseWithTopics(heading,topics);
    }

    @PreAuthorize("hasAnyRole'('ADMIN','USER')")
    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public List<Course> getAll() {
        return courseService.getAllCourses();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Course update(
            @PathVariable Long id,
            @RequestBody Course course
    ) {
        return courseService.updateCourse(id, course);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

}
