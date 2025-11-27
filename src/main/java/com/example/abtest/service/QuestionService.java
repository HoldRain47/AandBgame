package com.example.abtest.service;

import com.example.abtest.dto.QuestionDto;
import com.example.abtest.dto.QuestionSliceResponse;
import com.example.abtest.entity.Question;
import com.example.abtest.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    return questionRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException("질문을 찾을 수 없음");
    });
  }

  /**
   * 무한 스크롤을 위한 페이징 처리 메서드
   * 
   * @param page 페이지 번호 (0부터 시작)
   * @param size 페이지 크기
   * @return QuestionSliceResponse
   */
  public QuestionSliceResponse getQuestionsWithPaging(int page, int size) {
    // 최신순으로 정렬 (ID 내림차순)
    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
    Slice<Question> questionSlice = questionRepository.findAllBy(pageable);

    // Question 엔티티를 DTO로 변환
    List<QuestionDto> questionDtos = questionSlice.getContent().stream()
        .map(QuestionDto::from)
        .collect(Collectors.toList());

    // QuestionSliceResponse 생성
    QuestionSliceResponse response = new QuestionSliceResponse();
    response.setContent(questionDtos);
    response.setCurrentPage(questionSlice.getNumber());
    response.setSize(questionSlice.getSize());
    response.setHasNext(questionSlice.hasNext());

    return response;
  }

}
