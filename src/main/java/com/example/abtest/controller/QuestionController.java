package com.example.abtest.controller;

import com.example.abtest.entity.Question;
import com.example.abtest.repository.QuestionRepository;
import com.example.abtest.service.AnswerService;
import com.example.abtest.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {
  private final QuestionService questionService;
//  질문 목록 조회 (GET /questions)

  @GetMapping("/question")
  public String listQuestions(Model model) {
    List<Question> questions =questionService.getQuestions();
    model.addAttribute("questions", questions);
    return "/question/list";
  }
//  질문 생성 폼 (GET /questions/new)

//  질문 생성 처리 (POST /questions)
//  질문 상세 조회 (GET /questions/{id})
//  답변(투표) 생성 (POST /questions/{id}/answers)
//  A/B 투표 비율 계산 및 표시
}
