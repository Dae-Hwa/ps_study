class Solution {
    public int solution(int num) {
        int answer = 0;

        double result = num;

        while (result != 1) {
            answer++;
            if (500 < answer) {
                return -1;
            }

            if (result % 2 == 0) {
                result /= 2;
            } else {
                result = result * 3 + 1;
            }
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{6},
                new Object[]{16},
                new Object[]{626331}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int) arguments[0]));
        }
    }
}
