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
    String randomTitle = "Title." + random.nextInt(10);
    String randomOptionA = "OptionA." + random.nextInt(10);
    String randomOptionB = "OptionB." + random.nextInt(10);


    RandomTextDto rTxDto = new RandomTextDto();
    rTxDto.setTitle(messageSource.getMessage(randomTitle, null, "랜덤으로 만든 문제", null));
    rTxDto.setOptionA(messageSource.getMessage(randomOptionA, null, "랜덤 A", null));
    rTxDto.setOptionB(messageSource.getMessage(randomOptionB, null, "랜덤 B", null));
    return rTxDto;
  }
}
