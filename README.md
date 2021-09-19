
1. API 서버 구동 방법 (해당 클래스 실행)
groupware\src\main\java\com\groupware\springboot\Application.java

2. API 확인 방법 (postman을 사용.)

2-1. 부서원 추가 
[POST] localhost:8080/org/member
Body - raw - JSON 선택
아래의 예와 같이 입력
************************************
{
    "type" : "Member",
    "name" : "안정환",
    "code" : "001"
}
************************************

2-2. 부서원 수정
[PUT] localhost:8080/org/member/{memberId}
Body - raw - JSON 선택
아래의 예와 같이 입력
************************************
{
    "type" : "Member",
    "name" : "이강인",
    "code" : "005"
}
************************************

2-3. 부서원 삭제
[DELETE] localhost:8080/org/member/{memberId}

2-4. 단일조회
[GET] localhost:8080/org/organizations/{memberId}

2-5. 전체조회
[GET] localhost:8080/org/organizations




