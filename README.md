# DisJob



장애인 사용자의 특성을 고려하여 앱 사용자들의 일자리 선호도, 연봉을 기준으로 상위 순위의 일자리 정보들을 추천해주는 서비스입니다.


## 📌 주요 기능


- 사용자에게 적합한 일자리 정보 제공
- 사용자 커뮤니티 및 스크랩 기능


## 🛠 기술 스택


- FRONT-END PART


|구분|Skill|
|------|---|
|Platform|Android Studio|
|Language|Java|
|Networking|Volley|
|ETC|SharedPreferences|


## 📌 개발 내용


- Volley 라이브러리를 사용하여 서버와의 통신 구현
    - 직장 정보, 댓글, 회원 정보, 커뮤니티 등을 요청 및 수신
- Android XML로 UI 구현
- 웹뷰로 커뮤니티 화면, 회원가입 화면, 댓글 화면 연결


## 📌 성장 경험


### *지도 화면에서 대량 데이터 로딩으로 인한 앱 멈춤 현상 해결*

메인 화면에서 사용자가 지도를 이동할 때마다 해당하는 지역의 마커 데이터를 로드합니다. 이 과정에서 앱이 멈추는 현상을 겪었습니다.

이 문제는 지도 이동 시 데이터를 로드하고, 적합한 마커를 선별하며, 화면에 표시하는 작업이 모두 메인 스레드에서 처리되어 병목 현상이 발생한 것이 원인이었습니다.

이를 해결하기 위해 **ExecutorService**를 활용하여 비동기 처리를 구현했습니다. 데이터 로드와 가공 작업을 **ExecutorService**의 백그라운드 스레드에서 수행하고, 작업이 완료된 후에는 **Handler**를 사용해 메인 스레드에서 UI를 업데이트했습니다.

또한 불필요한 데이터 처리를 줄이고 성능을 개선하기 위해 지도에서 보이는 화면의 경계를 계산하여 해당 영역의 데이터만 서버에 요청하도록 로직을 수정했습니다.

앱 멈춤 현상은 완전히 해결되었고, 데이터 로드 속도는 60% 이상 단축되었습니다. 이 개선 작업을 통해 안드로이드 개발에서 중요한 성능 최적화 기법을 체득했습니다.


### *사용자 중심의 UI/UX 완성도 향상*

개발자로서 서비스를 완성했지만, 사용자 입장에서 보면 부족한 점이 많다는 것을 알게 되었습니다.

특히 이 서비스는 기존의 상권 분석 서비스에 비해 더 사용하기 쉬운 경험을 제공하는 것이 목표이기에, 사용자 경험에 더욱 집중해야 한다는 필요성을 느꼈습니다.

그리하여 사용자 테스트를 통해 직관적이지 않은 버튼, 메뉴 등의 UI 요소를 사용자가 쉽게 접근할 수 있도록 재배치했습니다. 

이 과정에서 기술적 완성도뿐 아니라 사용자 경험의 완성도가 서비스의 성공에 중요한 요소임을 깊이 이해하게 되었습니다.


## 📌 서비스 화면
![1111111111111111](https://github.com/user-attachments/assets/63a1f6eb-19a0-416f-b346-6fccecbdba9c)

![1111111111111111](https://github.com/user-attachments/assets/3c14f3c5-f73e-436a-a989-4f6ad160fe4e)

(시연 영상 - *https://youtube.com/shorts/SlzXLgIpZ40*)


<div align="center">

| ![image1](https://github.com/user-attachments/assets/7daedc76-a8c8-4f0b-8551-5d906a4a3830) | ![image2](https://github.com/user-attachments/assets/12492a51-b15a-4457-b86a-20fcceac3178) |
|:--------------------------------------------------------:|:--------------------------------------------------------:|
| **스클래시 화면**                                  | **메인 화면**                                  |
| ![image3](https://github.com/user-attachments/assets/63a1f6eb-19a0-416f-b346-6fccecbdba9c) | ![image4](https://github.com/user-attachments/assets/7a126a54-4d8e-4705-ada5-eaa9c815c28a) |
| **직장 추천 결과 화면**                                  | **직장 상세 화면**                                  |
| ![image5](https://github.com/user-attachments/assets/d9d603ce-10e4-4d49-977c-0eb8badeebd0) | ![image6](https://github.com/user-attachments/assets/8ea4e824-4914-4450-ad4c-ca19fd9c14df) |
| **게시판 화면**                                  | **정부 정책 게시판 화면**                                  |

</div>


