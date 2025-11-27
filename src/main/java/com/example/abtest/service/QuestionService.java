package com.example.abtest.service;

import com.example.abtest.entity.Question;
import com.example.abtest.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestionService {
  private final QuestionRepository questionRepository;

  public List<Question> getQuestions() {
    return questionRepository.findAll();
  }

  public Question createQuestion(Question question) {
    return questionRepository.save(question);
  }
  public Question getByidQuestion(Long id) {
    return questionRepository.findById(id).orElseThrow(()-> {
      throw new RuntimeException("질문을 찾을 수 없음");
    });
  }

}
