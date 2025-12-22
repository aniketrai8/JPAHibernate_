package com.example.jpaassignment.repository;

import com.example.jpaassignment.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {

}