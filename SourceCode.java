class Solution {
    public int solution(int n) {
        int answer = n + 1;

        while (Integer.bitCount(n) != Integer.bitCount(answer)) {
            answer++;
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{78},
                new Object[]{15}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int result = new Solution().solution((Integer) arguments[0]);

            System.out.println(result);
        }
    }
}
