package com.example.jpaassignment.model;


import jakarta.persistence.*;

@Entity
@Table(name="user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String username;
    private String password;
    private String role;

    public String getUsername(){
         return this.username= username;
    }

    public String getPassword(){
         return this.password=password;
    }
    public String getRole(){
       return this.role=role;
    }


}

