class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int currentNumber = left; currentNumber <= right; currentNumber++) {
            int submultipleCount = 0;
            for (int candidate = 1; candidate <= currentNumber / candidate; candidate++) {
                if (currentNumber % candidate == 0) {
                    if (candidate == currentNumber / candidate) {
                        submultipleCount++;
                    } else {
                        submultipleCount += 2;
                    }
                }
            }

            if (submultipleCount % 2 == 0) {
                answer += currentNumber;
            } else {
                answer -= currentNumber;
            }
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{13, 17},
                new Object[]{24, 27}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int) arguments[0], (int) arguments[1]));
        }
    }
}
