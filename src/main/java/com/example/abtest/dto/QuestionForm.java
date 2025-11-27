package com.example.abtest.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class QuestionForm {
    private String title;
    private  String optionA;
    private  String optionB;
    private MultipartFile imageA;
    private MultipartFile imageB;
}
