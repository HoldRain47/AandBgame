package com.example.abtest.repository;

import com.example.abtest.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {



}
