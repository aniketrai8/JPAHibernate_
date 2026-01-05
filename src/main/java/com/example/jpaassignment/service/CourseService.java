package com.example.jpaassignment.service;
import com.example.jpaassignment.repository.CourseRepository;
import com.example.jpaassignment.model.Course;
import java.util.*;
import com.example.jpaassignment.model.Topics;



import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class CourseService {

    private final  CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Transactional
    public Course createCourseWithTopics(String heading,List<String> topicHeadings){
        Course course = new Course(heading);

        for (String t: topicHeadings){ //understand
            Topics topic = new Topics(t);
            course.addTopics(topic);
        }

        return courseRepository.save(course);


    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Long id, Course updated) {
        Course course = getCourse(id);
        course.setHeading(updated.getHeading());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }


}
