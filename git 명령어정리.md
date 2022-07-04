
git commit -m "Add DDRRAA" 메시지 작성

로컬저장소와 깃허브 원격저장소(온라인)을 연결
git remote add origin http://github.com/kimmo05/TIL.git
git remote -v : 연결 확인
git push : 로컬저장소의 파일이 원격저장소(깃허브)로 올라감

git config --global user.name "kimmo05"
git config --global user.email  "longdali05@naver.com"

git config --global core.autocrlf true 

fatal: remote origin already exists. 오류시: git remote rm origin 

### 💡 Error 
###  🚫 CRLF will be replaced by LF (혹은 반대) 핸들링하는 방법<br>
warning: CRLF will be replaced by LF in some/file.file.
The file will have its original line endings in your working directory.
윈도우 사용시 LF will be replaced by CRLF in… 에러 메시지가 뜰 것이다.

원인: Whitespace 에러 
유닉스 시스템에서는 한 줄의 끝이 LF(Line Feed)로 이루어지는 반면,
윈도우에서는 줄 하나가 CR(Carriage Return)와 LF(Line Feed), 즉 CRLF로 이루어지기 때문이다

해결방법
core.autocrlf 를 켜는 것!
윈도우 (해당 프로젝트에만 적용하고 싶다면 --global을 빼준다)
```
git config --global core.autocrlf true
```
리눅스 ,맥 ```
git config --global core.autocrlf true input```
에러메시지 끄고 알아서 작업하고싶은 경우```
git config --global core.safecrlf false```
<br>
## 🚫 ! [rejected] main -> main (fetch first) 

원인: 원격저장소와 현재 작업중인 로컬저장소가 동기화되지 않았을때 발생<br>
동기화 하지 않은 상태에서 다시 push하면 데이터가 소실될 수 있어! 하고 경고해주는것.

해결방법
1. 동기화를 위해 pull
```
git pull --rebase origin main
```
2. 강제로 push
```
git push origin +main 
```
## 🚫 "Please move or remove them before you can merge."
문제가 되는 파일을 이동하거나 지워라
untracked 파일들이라 add 후 stash
```
git stash --all
git clean [옵션] : 모든 파일 지움 복원이안됨

덮어씌우는 목적
git add - a //변경사항을 스테이징 영역으로보냄
git stash //이를 임시저장하면서 워킹디렉토리를 HEAD commit으로 되돌림 --> status 깔끔
git pull -->적용
```



 Type	설명	예시
 FIX 
 버그, 오류 해결	 ex) [FIX] #10 - callback error
 ADD 
 Feat 이외의 부수적인 코드 추가/라이브러리 추가/ 새로운 View나 Activity 생성	 ex) [ADD] #11 - LoginActivity
 FEAT
 새로운 기능 구현	 ex) [FEAT] #11 - google login
 DEL 
 쓸모없는 코드 삭제	 ex) [DEL] #12 - unnecessary import package
 REMOVE
 파일 삭제	 ex) [REMOVE] #12 - 중복 파일 삭제
 REFACTOR 
 내부 로직은 변경 하지 않고 기존의 코드 개선하는 리팩토링 시, 세미콜론 줄바꿈 포함	 ex) [REFACTOR] #15 - MVP architecture to MVVM
 CHORE 
 그 이외의 잡일/ 버전 코드 수정, 패키지 구조 변경, 파일 이동, 가독성이나 변수명, reformat 등	 ex) [CHORE] #20 - delete unnecessary import package
 DESIGN
 just 화면	 ex) [DESIGN] #30 - iphone 12 레이아웃 조정
 COMMENT
 필요한 주석 추가 및 변경	 ex) [COMMENT] #30 - 메인 뷰컨 주석 추가
 DOCS	 README나 wiki 등 내용 추가 및 변경	 ex) [DOCS] #30 - README 내용 추가
 TEST 	 테스트 코드 추가	 ex) [TEST] #30 - 로그인 토큰 테스트 코드 추가 



🐛 :bug:	 버그나 오류를 수정합니다.
 💡 :bulb:	 소스 코드에 주석을 추가하거나 업데이트합니다.
 ✨ :sparkles:	 새로운 기능을 소개합니다.
 🔥 :fire:	 코드나 파일을 제거합니다.
 🎨 :art:	 코드의 구조 혹은 형식을 개선합니다.
 📝 :memo:	 문서(README나 Wiki)를 추가하거나 업데이트합니다.
 💄 :lipstick:	 UI 같은 스타일 내용을 추가하거나 업데이트합니다.
 🎉 :tada:	 프로젝트를 시작합니다.
 🚧 :construction:	 작업 진행중입니다.
 ♻️ :recycle:	 코드를 리팩토링합니다.
 🔧 :wrench:	 구성 파일을 추가하거나 업데이트합니다.
 🔨 :hammer:	 개발 스크립트를 추가하거나 업데이트합니다.
 ✏️ :pencil2:	 오타를 수정합니다.
 📦️ :package:	 컴파일된 파일 또는 패키지를 추가하거나 업데이트합니다.
 🚚 :truck:	 리소스(예시: 파일 경로)를 이동하거나 이름을 바꿉니다.
 🙈 :see_no_evil:	 .gitignore 파일을 추가하거나 업데이트합니다.
 💫 :dizzy:	 애니메이션 및 전환을 추가하거나 업데이트합니다.
 🩹 :adhesive_bandage:	 중요하지 않은 문제에 대한 간단한 수정입니다.
 💩 :poop:	 개선해야 할 나쁜 코드 표시
 🍻 :beers:	 맥주먹고 코딩함(?) 술에 취한 코딩(?)

커밋 규칙