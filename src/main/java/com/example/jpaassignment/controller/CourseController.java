package com.example.jpaassignment.controller;
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

    @PostMapping
    public Course createCourse(
        @RequestParam String heading,
        @RequestBody List<String>topics
    ){
        return courseService.createCourseWithTopics(heading,topics);
    }

}
