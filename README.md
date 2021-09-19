1. 서버 기동 (해당 클래스 실행)
groupware\src\main\java\com\groupware\springboot\Application.java

2. API 확인 방법 (postman을 사용.)

2-1. 등록 
[POST] localhost:8080/api/v1/posts
Body - raw - JSON 선택
아래의 예와 같이 입력
************************************
{
    "title" : "test2",
    "content" : "nanana",
    "author" : "pongpong"
}
************************************

2-2.단일조회
[GET] localhost:8080/api/v1/posts/{id}

2-3. 수정
[PUT] localhost:8080/api/v1/posts/{id}
Body - raw - JSON 선택
아래의 예와 같이 입력
************************************
{
    "title" : "test3",
    "content" : "nanana3"
}
************************************



