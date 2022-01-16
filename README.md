# [문제명](/)

## 요구사항

각 대학에서 d 일 안에 강연하면 p 만큼의 강연료를 지불한다.

가장 많은 돈을 벌 수 있도록 순회공연한 결과 출력

## 제한사항

### 입력

첫째 줄에 정수 n이 주어진다. 다음 n개의 줄에는 각 대학에서 제시한 p값과 d값이 주어진다.

### 출력

첫째 줄에 최대로 벌 수 있는 돈을 출력한다.

## 기타

매 순간 최대 값을 찾아야 한다. 일자별 최대값이 아니다.

바깥에서부터 세어 나가면 됨

특정 날짜 이후면서, 가장 큰 값으로

특정 날짜는 날짜 큰 순으로 정렬한 뒤, 오늘보다 크면 다 더하면 됨.

---

날짜 필요 없이 큰 금액을 그 날짜에 맞춰서 넣어주고, 겹치면 그 다음 빠른 날짜에 넣어주면 됨.
