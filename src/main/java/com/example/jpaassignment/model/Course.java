package com.example.jpaassignment.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//OneToMany Relation
@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heading;


    @OneToMany(mappedBy ="course",cascade = CascadeType.ALL, orphanRemoval= true)
    private Set<Topics> topics = new HashSet<>();

    @OneToMany(mappedBy ="course",cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Enrollment> enrollments = new HashSet<>();


    public Course() {
    }

    public Course(String heading) {
        this.heading = heading;
    }
    public void addTopics(Topics topic){
        topics.add(topic);
        topic.setCourse(this);
    }

    public void removeTopics(Topics t){
        topics.remove(t);
        t.setCourse(null);
    }

    public void addEnrollments(Enrollment e){
        enrollments.add(e);
        e.setCourse(this);
    }

    public void removeEnrollments(Enrollment e){
        enrollments.remove(e);
        e.setCourse(null);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id; }

    public String getHeading() {
        return heading;
    }
    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Set<Topics> getTopics() { return topics; }
    public void setTopics(Set<Topics> topics) { this.topics = topics; }

    public Set<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(Set<Enrollment> enrollments) { this.enrollments = enrollments; }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title='" + heading + '\'' + '}';

        //curd operations can be added here
    }

}