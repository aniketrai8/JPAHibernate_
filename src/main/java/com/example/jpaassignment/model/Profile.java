package com.example.jpaassignment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


//OneToOne Relation as the owning side
@Entity
@Table(name = "profiles")

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String phone;
    private String address;
    @OneToOne
    @JoinColumn(name = "student_id", unique = true)
    @JsonBackReference
    private Student student;

    public Profile() {}
    public Profile(String phone) {
        this.phone = phone;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) {
        this.student = student; }

    @Override
    public String toString(){
        return "profile{"+"id="+id+",phone="+phone+ '\''+'}';
    }

}
