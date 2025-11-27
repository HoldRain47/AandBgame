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
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 1)
  private String answerText;
  @Column(nullable = false, length = 500)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  private Question question;
}
