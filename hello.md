README.md 만들기

echo "# coding-test-java" >> README.md 
git init 
git add README.md 
git commit -m "first commit" 
git branch -M main 
<<<<<<< HEAD
git remote add origin https://github.com/Kimmo05/TIL.git
=======
git remote add origin https://github.com/Kimmo05/coding- test-java.git
>>>>>>> 818eac1a0802c3f3f355a9fa5f4332c370b6ba6b
 git push -u origin main

commit 하기
mkdir ~/dkdk //로컬디렉토리 만든다.
cmd /e/TIL
git init  : 깃 명령어를 사용할수있는 디렉토리로 만든다.
git status
git add * : 전체파일 add
git add 해당파일 : 해당파일 add
git status :상태확인 초록글자:커밋할 수 있는 상태

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
##### CRLF will be replaced by LF (혹은 반대) 핸들링하는 방법<br>
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
<<<<<<< HEAD

=======
>>>>>>> 818eac1a0802c3f3f355a9fa5f4332c370b6ba6b
##### ! [rejected] main -> main (fetch first) 

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