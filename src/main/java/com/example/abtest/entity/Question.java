package com.example.abtest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long id;

  @Column(nullable = false, length = 200)
  private  String title;
  @Column(nullable = false, length = 200)
  private  String optionA;
  @Column(nullable = false, length = 200)
  private  String optionB;

  private String imageA;
  private String imageB;
}
