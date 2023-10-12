# bnanum
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
