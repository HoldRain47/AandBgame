package com.example.abtest.service;

import com.example.abtest.dto.RandomTextDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RandomSrevice {
  private final MessageSource messageSource;

  public RandomTextDto getRandom() {
    Random random = new Random();
    int randomNum = random.nextInt(30) + 1; // 1~30 범위로 변경 (0 방지)
    String randomTitle = "Title." + random.nextInt(randomNum);
    String randomOptionA = "OptionA." + random.nextInt(randomNum);
    String randomOptionB = "OptionB." + random.nextInt(randomNum);
    System.out.println(randomTitle);
    System.out.println(randomOptionA);
    System.out.println(randomOptionB);

    RandomTextDto rTxDto = new RandomTextDto();
    rTxDto.setTitle(messageSource.getMessage(randomTitle, null, "랜덤으로 만든 문제", null));
    rTxDto.setOptionA(messageSource.getMessage(randomOptionA, null, "랜덤 A", null));
    rTxDto.setOptionB(messageSource.getMessage(randomOptionB, null, "랜덤 B", null));
    return rTxDto;
  }
}
