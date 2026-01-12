package com.example.jpaassignment.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@NamedQuery(
        name = "Student.findWithMoreThanNCourses",
        query = """
        SELECT s
        FROM Student s
        JOIN s.enrollments e
        GROUP BY s
        HAVING COUNT(e) > :count
    """
)
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One Student One Profile (inverse side)
    @OneToOne(
            mappedBy = "student", //
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private Profile profile;

    // One Student  Many Enrollments
    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Enrollment> enrollments = new HashSet<>();

    public Student() {}

    public Student(String name) {
        this.name = name;
    }


    public void addEnrollment(Enrollment e) {
        enrollments.add(e);
        e.setStudent(this);
    }

    public void removeEnrollment(Enrollment e) {
        enrollments.remove(e);
        e.setStudent(null);
    }


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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        if (profile != null) {
            profile.setStudent(this);
        }
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
