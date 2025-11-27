package com.example.abtest.controller;

import com.example.abtest.entity.Answer;
import com.example.abtest.entity.Question;
import com.example.abtest.service.AnswerService;
import com.example.abtest.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RequestMapping("/questions")
@Controller
@RequiredArgsConstructor
public class QuestionController {
  private final QuestionService questionService;
  private final AnswerService answerService;
  // 질문 목록 조회 (GET /questions)

  @GetMapping("")
  public String listQuestions(Model model) {
    List<Question> questions = questionService.getQuestions();
    model.addAttribute("questions", questions);
    return "/questions/list";
  }

  // 질문 생성 폼 (GET /questions/new)
  @GetMapping("/new")
  public String createQuestionForm(Model model) {
    Question question = new Question();
    model.addAttribute("question", question);
    return "/questions/create";
  }

  // 질문 생성 처리 (POST /questions)
  @PostMapping("/new")
  public String createQuestion(@ModelAttribute Question question) {
    questionService.createQuestion(question);
    return "redirect:/questions";
  }

  // 질문 상세 조회 (GET /questions/{id})
  @GetMapping("{id}")
  public String getQuestionDetail(@PathVariable Long id, Model model) {

    Question question = questionService.getByidQuestion(id);
    List<Answer> answers = answerService.getAnswersByQuestionId(id);

    // 투표 통계 계산
    long countA = answers.stream().filter(a -> "A".equals(a.getAnswerText())).count();
    long countB = answers.stream().filter(a -> "B".equals(a.getAnswerText())).count();
    long totalVotes = countA + countB;

    double percentageA = totalVotes > 0 ? Math.round((countA * 100.0 / totalVotes) * 10) / 10.0 : 0;
    double percentageB = totalVotes > 0 ? Math.round((countB * 100.0 / totalVotes) * 10) / 10.0 : 0;

    model.addAttribute("question", question);
    model.addAttribute("answers", answers);
    model.addAttribute("countA", countA);
    model.addAttribute("countB", countB);
    model.addAttribute("totalVotes", totalVotes);
    model.addAttribute("percentageA", percentageA);
    model.addAttribute("percentageB", percentageB);

    return "/questions/detail";
  }
  // 답변(투표) 생성 (POST /questions/{id}/answers)

  @PostMapping("{id}/answers")
  public String createAnswer(
      @PathVariable Long id,
      @RequestParam("answerText") String answerText,
      @RequestParam(value = "content", required = false, defaultValue = "") String content) {

    Question question = questionService.getByidQuestion(id);

    // 새로운 Answer 객체 생성
    Answer answer = new Answer();
    answer.setAnswerText(answerText);
    answer.setContent(content); // 빈 문자열도 허용
    answer.setQuestion(question);

    answerService.createAnswer(answer);
    return "redirect:/questions/" + id;
  }
  //랜덤 질문 보기 (GET /questions/random)
  @GetMapping("/random")
  public String randomQuestions(Model model) {
    Random random = new Random();
    int maxNum = questionService.getQuestions().size();
    Long randomNum = Integer.toUnsignedLong(random.nextInt(maxNum)+1);
    System.out.println(randomNum);
    questionService.getByidQuestion(randomNum);


    return "redirect:/questions/" + randomNum;


  }



}
