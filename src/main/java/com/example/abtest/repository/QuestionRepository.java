package com.example.abtest.repository;

import com.example.abtest.entity.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // 무한 스크롤을 위한 Slice 기반 페이징 메서드
    Slice<Question> findAllBy(Pageable pageable);
}
