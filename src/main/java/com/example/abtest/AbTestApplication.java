package com.example.abtest;

import com.example.abtest.entity.Answer;
import com.example.abtest.entity.Question;
import com.example.abtest.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AbTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(AbTestApplication.class, args);
  }
  // 샘플 데이터 생성
}
