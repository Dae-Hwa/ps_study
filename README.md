# [뉴스 클러스터링](https://programmers.co.kr/learn/courses/30/lessons/17677#)

## 요구사항

자카드 유사도
교집합 크기 / 합집합 크기

{1, 2, 3}, {2, 3, 4}
- 교집합 : {2, 3}
- 합집합 : {1, 2, 3, 4}
- 자카드 유사도 : 2 / 4 = 0.5
  ** 공집합이 있으면 나눗셈 불가하므로 1로 정의

다중집합을 허용하는 자카드 유사도를 이용해 문자열 사이의 유사도를 계산
** 두 글자씩 계산한다.. 01, 12, 23, 34 와 같이

## 제한사항

- 입력으로는 `str1`과 `str2`의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
- 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다. 예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
- 다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.

입력으로 들어온 두 문자열의 자카드 유사도를 출력한다. 유사도 값은 0에서 1 사이의 실수이므로, 이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.

## 기타

처음엔 단순 문자열로 처리하려고 해서 막혔다. 다중집합이기 때문에 단순히 Set으로 할 경우 동일 집합 내에서 중복되는 원소가 사라진다. Multi Set이 필요하다. 따라서 Map을 이용했다.

---

다른 사람의 풀이 중 List에 담고 교집합일 경우 List에서 뺀 뒤 합집합을 구하는 식으로 풀이한 사람도 있었다. 코드는 비교적 가벼워지나 평균적인 속도는 Map이 훨씬 
