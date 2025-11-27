package com.example.abtest.service;

import com.example.abtest.entity.Answer;
import com.example.abtest.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
  private final AnswerRepository answerRepository;

  public Answer createAnswer(Answer answer) {
    return answerRepository.save(answer);
  }

  public List<Answer> getAnswersByQuestionId(Long questionId) {
    return answerRepository.findByQuestionId(questionId);
  }
}