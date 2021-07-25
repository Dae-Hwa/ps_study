class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for (char each : s.toCharArray()) {
            if (cnt < 0) {
                return false;
            }

            if (each == '(') {
                cnt++;
                continue;
            }

            cnt--;
        }

        return cnt == 0;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{"()()"},
                new Object[]{"(())()"},
                new Object[]{")()("},
                new Object[]{"(()("}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((String) arguments[0]));
        }
    }
}
