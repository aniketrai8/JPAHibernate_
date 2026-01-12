package com.example.jpaassignment.repository;

import com.example.jpaassignment.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <AppUser,Long> {
    Optional<AppUser> findByUsername(String username);
}
