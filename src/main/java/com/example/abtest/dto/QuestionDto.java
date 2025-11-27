package com.example.abtest.dto;

import com.example.abtest.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private Long id;
    private String title;
    private String optionA;
    private String optionB;
    private String imageA;
    private String imageB;

    // Question 엔티티를 DTO로 변환하는 정적 팩토리 메서드
    public static QuestionDto from(Question question) {
        QuestionDto dto = new QuestionDto();
        dto.setId(question.getId());
        dto.setTitle(question.getTitle());
        dto.setOptionA(question.getOptionA());
        dto.setOptionB(question.getOptionB());
        dto.setImageA(question.getImageA());
        dto.setImageB(question.getImageB());
        return dto;
    }
}
