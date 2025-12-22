package com.example.jpaassignment.repository;

import com.example.jpaassignment.model.Topics;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicRepository extends JpaRepository<Topics,Long> {

}