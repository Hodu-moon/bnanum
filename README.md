# bnanum
---
다쓴 비싼 전공책을 파는곳은 많다. 
학기마다 사용하는 전공책은 거의 바뀌지 않는데 구분해서 보여주는 곳은 없다
조선대 컴공 학생들을 위한 전공책 나눔 앱 
Ex) 3학년 1학기 전공책 나누는거

----
## Used Stack 
client : Android
BackEnd : Spring Boot, Spring Data JPA, H2 Database(test), MySql

Spring framework로 만든 RESTful API 서버와 이를 이용한 Android앱 구조

![image](https://github.com/Hodu-moon/bnanum/assets/82320750/5e634faf-6270-428f-bfa6-aefb52b4fa5c)
---

## 구현 할 기능

* 회원 가입
* 로그인
* 나눔 글 추가, 삭제
* 채팅 기능

---

|기능|Method|URL|Parameter|
|------|---|---|---|
|회원가입|POST|/users| ... |
|로그인|POST| /users/login| ... |
|글 조회|GET|/board/{id}| ... |
|글 생성| POST |/board/create| ... |
|채팅| GET |/chat{id}|...|

----
## 전체 프로젝트 설계 구조
![image](https://github.com/Hodu-moon/bnanum/assets/82320750/f24bb799-3c5d-4c8c-a417-930aef2ac15a)
