
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
