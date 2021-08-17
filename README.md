# [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

## 요구사항

integer배열 nums가 있고, 사이즈가 k인 슬라이딩 윈도우가 있다. 이는 배열의 가장 왼쪽에서 오른쪽으로 움직인다.

윈도우에서는 k개의 숫자만 볼 수 있다. 슬라이동은 한 번에 오른쪽으로 한 칸씩 움직인다.

슬라이딩 윈도우의 max를 반환

## 제한사항

1 <= nums.length <= 10^5

-10^4 <= nums[i] <= 10^4

1 <= k <= nums.length

## 기타

그냥 배열만으로는 풀리지 않는다.

중간에 홀딩할 무언가가 필요하다. 보통 deque를 많이 쓰는 듯 하다.
