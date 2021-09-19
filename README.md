# [공정 컨설턴트 호석](https://www.acmicpc.net/problem/22254)

## 요구사항

주문 N개가 있다.

공정라인 K개가 있을 때, 각 주문을 사용시간이 가장 적은 공정 라인에 배정한다.

공정라인의 사용 시간은 배정된 주문 시간의 총합

남은시간 X 동안 최소 공정 라인의 개수 K를 찾아서 출력

## 제한사항

첫 번째 줄에 맞춤형 선물 주문의 개수 N, 제작 완료까지 남은 시간 X가 공백으로 구분되어 주어진다.

두 번째 줄에는 1번부터 N번 선물이 필요한 공정 시간이 순서대로 주어진다. 단위는 '시간' 이다.

1 ≤ N ≤ 100,000, N은 자연수이다.

1 ≤ X ≤ 10^9, X는 자연수이다.

1 ≤ 각 선물의 공정 시간 ≤ X, 모든 시간은 자연수이다.

## 기타

공정의 최대 개수 -> 작업의 개수

K 범위를 좁히며 이분탐색

공정라인 판단은

정렬 <- 실패(잘못된 로직)
   - 5 2 8 4 3 5 -> 2, 3, 4, 5, 5, 8
   - K 크기의 배열에 순서대로 반복하여 삽입, 최대값 갱신
   - 예를 들어, K가 3이면, 2 + 5, 3 + 5, 4 + 8의 순서로 삽입됨. 이 경우 작업은 12시간에 끝남.

---

정렬하면 안 됨(요구사항)

5 2 8 4 3 5 -> 5 + 3, 2 + 4 + 5, 8 가 되어야함.

배열 대신 우선순위 큐 사용

실패 -> 최대값을 인덱스로 생각했음.
