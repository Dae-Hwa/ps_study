class Solution {
    public int solution(int n) {
        int answer = 1;
        int lastStartingPoint = 1;
        int cur = 0;
        for (int i = 1; i < n; i++) {
            cur += i;

            while (n <= cur) {
                if (n == cur) {
                    answer++;
                }

                cur -= lastStartingPoint;
                lastStartingPoint++;
            }
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{15}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int result = new Solution().solution((Integer) arguments[0]);

            System.out.println(result);
        }
    }
}
