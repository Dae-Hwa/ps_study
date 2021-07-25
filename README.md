# [파일명 정렬](https://programmers.co.kr/learn/courses/30/lessons/17686)

## 요구사항

HEAD-NUMBER-TAIL 과 같은 형식의 파일을 HEAD이후 NUMBMER 순으로 정렬

파일은 files 배열로 주어진다.

## 제한사항

files <= 1000

파일명 <= 100

파일명은 아래의 문자만 가능

- 영어 대소문자
- 숫자
- 공백
- 마침표
- 하이픈(-)

HEAD는 숫자가 아닌 문자. 한 글자 이상, 대소문자 구분하지 않음

NUMBER는 최대 다섯 글자 사이의 연속된 숫자. 0부터 시작할 수 있다.

TAIL은 나머지 부분

## 기타

Arrays.sort는 퀵소트, Collections.sort는 머지소트라고 한다.
