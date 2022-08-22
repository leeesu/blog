# Spring 입문주차 과제 : 블로그 백엔드 서버 만들기


## USECASE
![usecase11](https://user-images.githubusercontent.com/46406965/185973292-e29d68b0-b272-4299-8caf-71df975e00b0.jpg)

## 나만의 블로그 API명세서

|Request(요청)|Method|URL|Response(응답)|기능|
|:--:|:--:|:--:|:--:|:--:|
|전체게시글 리스트조회| `GET`|/api/blog|{ “postNo” : “글번호”, “title” : “글제목”}|게시글 리스트를 출력한다.|
|게시글 등록| `POST`|/api/blog||작성된 게시글을 등록한다.|
|게시글 상세조회| `GET` | /api/blog/{id}|{ “postNo” : “글번호”, “title” : “글제목”, “content” :”글내용”}|작성된 게시글 상세조회|
|게시글 수정| `PUT`| api/blog/{id} |{ “postNo” : “글번호”, “title” : “글제목”, “content” :”글내용”}|해당 게시글을 수정한다.|
|게시글 삭제| `DELETE`|/api/blog/{id}||해당하는 게시글을 삭제한다.|
