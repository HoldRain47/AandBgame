# AandBgame

## 필수 기능 ( 구현 완료)

> 질문 목록 조회 (GET /questions)
> 
> 
> 질문 생성 폼 (GET /questions/new)
> 
> 질문 생성 처리 (POST /questions)
> 
> 질문 상세 조회 (GET /questions/{id})
> 
> 답변(투표) 생성 (POST /questions/{id}/answers)
> 
> A/B 투표 비율 계산 및 표시
> 

## 추가 기능( 구현 완료)

> 랜덤 질문 보기 (GET /questions/random)
> 
> 
> 투표 수 표시 (예: "A: 3표 (60%)")
>
> 무한 스크롤 (Spring Data JPA의 Slice를 활용한 페이징 처리와 Intersection Observer API를 사용한 순수 JavaScript 기반 무한 스크롤 구현)
>
> 파일 업로드 (멀티파일 업로드 사용하여서 로컬에 저장)
>
> 더미 데이터 추가 (개발 & 배포버전에 따라 버튼 숨기기 -> 구현 x)
>
> 에러페이지 처리 (404, 500에러에 대한 에러 페이지 통합 -> WebServerFactoryCustomizer 사용)
