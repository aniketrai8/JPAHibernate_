package com.example.jpaassignment.model;

import jakarta.persistence.*;



//ManyToOne with Course as owning side
@Entity
@Table(name = "Topics")
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")

    private Course course;


    public Topics() {}
    public Topics(String name) {
        this.name = name;
    }

    public void Topics(){}
    public void Topics(String name) {
        this.name = name; }

//getter and Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {

        return course;
    }
    public void setCourses(Course course){
        this.course=course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString(){
        return "Module{"+"id="+",name '"+name+ '\''+'}';

    }

}
