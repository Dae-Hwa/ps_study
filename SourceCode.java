class Solution {
    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{3},
                new Object[]{4},
                new Object[]{0}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String result = new Solution().solution((int) arguments[0]);

            System.out.println(result);
        }
    }
}
