package com.example.abtest.controller;

import com.example.abtest.entity.Answer;
import com.example.abtest.entity.Question;
import com.example.abtest.repository.QuestionRepository;
import com.example.abtest.service.AnswerService;
import com.example.abtest.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RequestMapping("/questions")
@Controller("/")
@RequiredArgsConstructor
public class QuestionController {
  private final QuestionService questionService;
  private final AnswerService answerService;
//  질문 목록 조회 (GET /questions)

  @GetMapping("")
  public String listQuestions(Model model) {
    List<Question> questions =questionService.getQuestions();
    model.addAttribute("questions", questions);
    return "/questions/list";
  }
//  질문 생성 폼 (GET /questions/new)
  @GetMapping("/new")
  public String createQuestionForm(Model model) {
    Question question = new Question();
    model.addAttribute("question", question);
    return "/questions/create";
  }
//  질문 생성 처리 (POST /questions)
  @PostMapping("/new")
  public String createQuestion(@ModelAttribute Question question) {
    questionService.createQuestion(question);
    return "redirect:/questions";
  }

//  질문 상세 조회 (GET /questions/{id})
  @GetMapping("{id}")
  public String getQuestionDetail(@PathVariable Long id, Model model){

    Question question = questionService.getByidQuestion(id);
    model.addAttribute("question", question);
    return  "/questions/detail";
  }
//  답변(투표) 생성 (POST /questions/{id}/answers)

  @PostMapping("/answer/new")
  public String createAnswer(@PathVariable Long id, @ModelAttribute Answer answer){

    answer.setQuestion(questionService.getByidQuestion(id));
    answerService.createAnswer(answer);
    return "redirect:/questions/detail/" + id;
  }
//  A/B 투표 비율 계산 및 표시
}
