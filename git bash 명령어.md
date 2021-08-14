
$ cd ~ :홈 디렉토리로 이동

$ mkdir [디렉토리명] : 새 디렉토리에 디렉토리명 생성

$ pwd : 현재 경로 출력

$ ls : 디렉토리 내용을 출력

{
-l : 상제정보까지
-a : 숨김파일과 디렉토리까지
tip: 합쳐서 -al처럼 사용가능    
}

$ rm -r [디렉토리명] : 파일에있는 디렉토리를 삭제

$ vim [파일명.확장자명] : vi편집기로 [파일명.확장자명]파일을 작성



$ git init :현재 위치에서 지역 저장소를 생성


$ git config --global user.name "[사용자명]" :깃 환경에서 사용자 이름을 [사용자명]으로 지정


$ git config --global user.email "[사용자이메일명]"
: 깃 환경에서 사용자 이메일을 [사용자이메일명]으로 지정

$ git status : 깃의 상태를 확인

$ git add [파일명.확장자명] : [파일명.확장자명]을 스테이지에 올림

$ git commit -m "[메시지명]" :  커밋 메시지 [메시지명]을 붙여 커밋

$ git log

$ git log --pretty=oneline   # 한줄로 표기하기

git show [커밋 id] :특정 커밋

git checkout [커밋 해시] : 지정한 커밋 해시로 이동

$ git reset HEAD^ # 현재 HEAD의 이전 커밋으로 되돌리기

$ git reset HEAD~n # 현재로 부터 n 번째 이전 커밋으로 되돌리기

$ git reset [커밋 해시] :지정한 커밋 해시로 이동하고 커밋을 취소

$ git reset --soft [커밋ID]  # head 만 바뀜

$ git reset --mixed [커밋ID] # staging 도 그 때로 바뀜

$ git reset --hard [커밋ID] # working디렉토리/staging 모두 그 때로 바꿈 

$ git revert [커밋 해시] : 지정한 커밋 해시의 변경 이력을 취소

파일 수정 한 뒤
$ git add .

$ git commit --amend  : 최신 커밋 수정

$ git branch [브랜치명] : 새로운 브랜치 [브랜치명]을 생성

$ git checkout [브랜치명] : [브랜치명]으로 체크아웃(이동)

$ git checkout -b [브랜치명]  # 브랜치만들고 바로 이동

$ git branch -d 브랜치명 : 브랜치 삭제

$ git log --oneline : 커밋 로그에서 한 줄에 한 커밋씩 출력

$ git merge [브랜치명] :[브랜치명]을 master 브랜치와 병합 //

$ git merge [브랜치명] --edit // 병합 후 바로 vi 편집기가 나오면서 커밋 메시지 수정 가능

$ git merge [브랜치명] --no-edit // 커밋 메시지 수정없이 바로 병합

$ git merge --abort : merge 취소하기

$ git remote add origin [github 레포지 주소] :원격 저장소에 연결

(git remote add origin https://github.com/Kimmo05/TIL.git)

$ git remote add origin [branch 이름]   #없으면 생성됨

$ git remote -v :  원격 저장소에 연결됐는지 확인

$ git push -u origin master : 지역 저장소의 커밋을 맨 처음 원격 저장소에 올리는 경우

$ git push : 지역 저장소의 커밋을 원격 저장소에 올리는 경우(업로드)

$ git push origin master

$ git pull :원격 저장소의 커밋을 지역 저장소로 가져옴

$ git pull origin master

$ git clone [원격 저장소 주소] : 원격 저장소를 [지역저장소명]에 복제하기

$ git fetch : 원격 저장소의 커밋을 가져오기만 하고 merge하지 않는다
가져온 branch 내용은 origin/[브랜치] 로 저장됨

이후엔 diff 로 비교

$ git diff test origin/test # 브랜치 이름이 test일 경우 예시
9) 패치로 가져온 정보가 있는 브랜치\[FETCH\_HEAD\]로 이동

```git
$ git checkout FETCH_HEAD

$ git merge FETCH_HEAD :패치로 가져온 정보가 있는 브랜치[FETCH_HEAD]를 master 브랜치에 병합한다

$ git checkout -b [브랜치명] : [브랜치명]을 만드는 것과 동시에 체크아웃한다


$ git reset [커밋메시지] [커밋해시] : 현재 커밋을 다른 브랜치에 있는 [커밋메시지] 커밋으로 되돌림

$ git reset --hard: 돌아간 커밋 이후의 변경이력을 전부 삭제 
$ git reset --mixed: 변경이력은 전부삭제
변경된 내용은 남아있음
$ git reset --soft : 변경이력은 전부삭제
변경된 내용은 남아있따.