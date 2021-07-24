import java.util.Arrays;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{2, 5},
                new Object[]{4, 3},
                new Object[]{-4, 2}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            long[] result = new Solution().solution((int) arguments[0], (int) arguments[1]);

            System.out.println(Arrays.toString(result));
        }
    }
}
