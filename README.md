# [거리두기 확인하기](https://programmers.co.kr/learn/courses/30/lessons/81302)

## 요구사항

대기실 places가 주어진다. 

- 대기실은 5개이며 각 대기실은 5x5 크기이다.

- 응시자들끼리 맨해튼 거리 2 이하로는 앉을 수 없다.
    > 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 

  - 파티션이 막혀있을 경우는 허용된다.

거리두기가 잘 지켜지면 1, 아니면 0을 리턴한다.

## 제한사항

places의 행 길이는 5

- 각 행은 대기실 하나

places의 열 길이는 5

- 대기실 하나의 크기는 5x5

places의 원소는 P,O,X로 이루어진 문자열입니다.
    - places 원소의 길이(대기실 가로 길이) = 5
    - P는 응시자가 앉아있는 자리를 의미합니다.
    - O는 빈 테이블을 의미합니다.
    - X는 파티션을 의미합니다.



## 기타
