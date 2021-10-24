class Solution {
    public int solution(int n) {
        int answer = 0;

        int left = 1;
        int cur = 0;
        for (int i = 1; i <= n; i++) {
            cur += i;

            while (n < cur) {
                cur -= left;
                left++;
            }

            if (cur == n) {
                answer++;
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
