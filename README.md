# [우유 축제](https://www.acmicpc.net/problem/14720)

## 요구사항

거리를 지나가면서 0, 1, 2 순으로 우유 마시기

한 번 지나온 곳으로 돌아갈 수 없다.

## 제한사항

첫째 줄에 우유 가게의 수 N이 주어진다. (1 ≤ N ≤ 1000)

둘째 줄에는 우유 가게 정보가 우유 거리의 시작부터 끝까지 순서대로 N개의 정수로 주어진다.

0은 딸기우유만을 파는 가게, 1은 초코우유만을 파는 가게, 2는 바나나우유만을 파는 가게를 뜻하며, 0, 1, 2 외의 정수는 주어지지 않는다.

## 기타

안 마신 경우를 매번 고려해야 한다고 판단.

0 1 0 1 2 0 과 같은 경우가 생길 수 있기 때문에

0 1 / 0 1 2 0

-> dfs로 풀이, 시간초과
