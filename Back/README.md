
# HappyHouse REST API PROJECT
> 아파트 거래 정보 제공 사이트에 대한 REST API 설계 및 구현


## REST API 설계
![image.png](img/image.png)


## 구현 테스트

> insomnia tool을 이용한 REST 통신 결과입니다.

### 지역 LIST
![region_sido.PNG](img/region_sido.PNG)
![region_gugun.PNG](img/region_gugun.PNG)
![region_dong.PNG](img/region_dong.PNG)

### Apt 
|관심 지역 추가|관심 지역 삭제|
| ---------| ---------|
|![interest_관심지역 추가.PNG](img/interest_관심지역 추가.PNG)|![interest_관심지역 삭제.PNG](img/interest_관심지역 삭제.PNG)


|관심 아파트 추가|관심 아파트 삭제|
| ---------| ---------|
|![interest_관심 아파트 추가.PNG](img/interest_관심 아파트 추가.PNG)|![interest_관심아파트 삭제.PNG](img/interest_관심아파트 삭제.PNG)|


### User 
|로그인|로그아웃|
| ---------| ---------|
|![user_로그인.png](img/user_로그인.png)|![user_로그아웃_세션 제거.png](img/user_로그아웃_세션 제거.png)|

|전체 유저 가져오기|상세보기|
| ---------| ---------|
|![user_전체 유저 가져오기.png](img/user_전체 유저 가져오기.png)|![user_유저 하나 가져오기.png](img/user_유저 하나 가져오기.png)|

|추가|추가 후 전체 유저 가져오기|
| ---------| ---------|
|![user_유저 추가.png](img/user_유저 추가.png)|![user_유저 추가 후 전체 유저 가져오기.png](img/user_유저 추가 후 전체 유저 가져오기.png)|

|수정|수정 후 전체 유저 가져오기|
| ---------| ---------|
|![user_유저 수정.png](img/user_유저 수정.png)|![user_유저 수정 후 전체 유저 가져오기.png](img/user_유저 수정 후 전체 유저 가져오기.png)|

|삭제|삭제 후 전체 유저 가져오기|
| ---------| ---------|
|![user_유저 삭제.png](img/user_유저 삭제.png)|![user_유저 삭제 후 전체 유저 가져오기.png](img/user_유저 삭제 후 전체 유저 가져오기.png)|



### Board
|전체 글 가져오기|상세보기|
| ---------| ---------|
| ![board_전체_글_가져오기.png](img/board_전체_글_가져오기.png)| ![board_게시판 글 하나 가져오기.png](img/board_게시판 글 하나 가져오기.png)

|추가|추가 후 전체 글 가져오기|
| ---------| ---------|
|![board_글_추가.png](img/board_글_추가.png) | ![board_글_추가 후 전체 글 가져오기.png](img/board_글_추가 후 전체 글 가져오기.png)|

|수정|수정 후 전체 글 가져오기|
| ---------| ---------|
|![board_글_수정.png](img/board_글_수정.png) | ![board_글 수정 후 전체 글 가져오기.png](img/board_글 수정 후 전체 글 가져오기.png)|

|삭제|삭제 후 전체 글 가져오기|
| ---------| ---------|
|![board_글_삭제.png](img/board_글_삭제.png)|![board_글 삭제 후 전체 글 가져오기.png](img/board_글 삭제 후 전체 글 가져오기.png)|

### Notice
|전체 글 가져오기|상세보기|
| ---------| ---------|
|![notice_전체 글 가져오기.png](img/notice_전체 글 가져오기.png)|![notice_공지사항 글 하나 가져오기.png](img/notice_공지사항 글 하나 가져오기.png)|

|추가|추가 후 전체 글 가져오기|
| ---------| ---------|
|![notice_글 추가.png](img/notice_글 추가.png)|![notice_글 추가 후 전체 글 가져오기.png](img/notice_글 추가 후 전체 글 가져오기.png)|

|수정|수정 후 전체 글 가져오기|
| ---------| ---------|
|![notice_글 수정.png](img/notice_글 수정.png)|![notice_글 수정 후 전체 글 가져오기.png](img/notice_글 수정 후 전체 글 가져오기.png)|

|삭제|삭제 후 전체 글 가져오기|
| ---------| ---------|
|![notice_글 삭제.png](img/notice_글 삭제.png)|![notice_글 삭제 후 전체 글 가져오기.png](img/notice_글 삭제 후 전체 글 가져오기.png)|




## 향후 개발 내용

* 0.0.1
    * REST API 설계
* 0.0.2
    * swagger 추가 예정
* 0.0.3
    * vue.js를 이용한 Front 설계
 * 0.0.4
    * Spring Secuity를 이용한 jwt 사용



