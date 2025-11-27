package com.example.abtest.controller;

import com.example.abtest.dto.QuestionSliceResponse;
import com.example.abtest.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionApiController {
    private final QuestionService questionService;

    /**
     * 무한 스크롤을 위한 질문 목록 조회 API
     * 
     * @param page 페이지 번호 (기본값: 0)
     * @param size 페이지 크기 (기본값: 10)
     * @return QuestionSliceResponse
     */
    @GetMapping("")
    public ResponseEntity<QuestionSliceResponse> getQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        QuestionSliceResponse response = questionService.getQuestionsWithPaging(page, size);
        return ResponseEntity.ok(response);
    }
}
