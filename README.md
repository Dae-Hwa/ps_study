# [쿼드압축 후 개수 세기](https://programmers.co.kr/learn/courses/30/lessons/68936)

## 요구사항

0과 1로 이루어진 2^n x 2^n 크기의 2차원 정수 배열 arr이 주어진다.

이를 [쿼드 트리](https://programmers.co.kr/learn/courses/30/lessons/68936)와 같은 방식으로 압축하려고 한다.

- 압축하고자 하는 영역 S 내부에 있는 모든 수가 같은 값이라면 S를 해당 수 하나로 압축시킨다.

- 그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역으로 쪼갠다. 각 정사각형 영역에 대해 같은 방식의 압축을 시도한다.
  - 가장 작은 단위는 컬럼 하나(정사각형 한 칸)이 된다.

위의 방식으로 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return


## 제한사항

`1 <= arr.length <= 1024`
> 2의 제곱수 형태

`arr[*].length = arr.length` (정사각형)
> `arr[*] == 0 || 1` 


## 기타

- 재귀적으로 가면 좋을듯? -> 최대 2^10이므로 뎁스 최대 10?
