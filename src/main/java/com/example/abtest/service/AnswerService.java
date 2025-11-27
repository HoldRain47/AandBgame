package com.example.abtest.service;

import com.example.abtest.entity.Answer;
import com.example.abtest.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {
  private final AnswerRepository answerRepository;


  public Answer createAnswer(Answer answer){
    return answerRepository.save(answer);
  }
}
