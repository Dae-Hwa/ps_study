import java.util.*;

class Solution {
    public String solution(int n) {
        int[] numbers = new int[]{1, 2, 4};

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n; 0 < i; i /= 3) {
            i--;
            stack.push(numbers[i % 3]);
        }

        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.toString();
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{1},
                new Object[]{2},
                new Object[]{3},
                new Object[]{4},
                new Object[]{10}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int) arguments[0]));
        }
    }
}
