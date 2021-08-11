class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                answer += i;
                if (i != n / i) answer += n / i;
            }
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{12},
                new Object[]{5}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int) arguments[0]));
        }
    }
}
