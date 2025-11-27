package com.example.abtest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSliceResponse {
    private List<QuestionDto> content; // 질문 목록
    private int currentPage; // 현재 페이지 번호
    private int size; // 페이지 크기
    private boolean hasNext; // 다음 페이지 존재 여부
}
