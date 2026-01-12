package com.example.jpaassignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enrollments", uniqueConstraints = @UniqueConstraint(columnNames = { "students_id","course_id"}))
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="students_id",nullable=false)

    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id",nullable = false)
    private Course course;
    private String grade;

    //holds both foreign key
    public Enrollment(){}
    public Enrollment(Student student,Course course){
        this.student= student;
        this.course= course;


    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }


    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String  toString(){
        return "Enrollment{" + "id=" + id + ", studentId=" +
                (student != null ? student.getId() : null) +
                ", courseId=" + (course != null ? course.getId() : null) + '}';

    }




}
