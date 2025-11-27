package com.example.abtest.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RandomTextDto {
  private  String title;
  private  String optionA;
  private  String optionB;
}
