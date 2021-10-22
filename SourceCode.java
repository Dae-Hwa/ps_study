import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (List<Integer> combination : combination(nums.length, 3)) {
            int num = 0;

            for (int each : combination) {
                num += nums[each];
            }

            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private List<List<Integer>> combination(int n, int r) {
        List<List<Integer>> combination = new ArrayList<>();
        combination(combination, n, r, new ArrayDeque<>());
        return combination;
    }

    private void combination(List<List<Integer>> combination, int n, int r, Deque<Integer> stack) {
        if (stack.size() == r) {
            combination.add(new ArrayList<>(stack));
            return;
        }

        for (int i = stack.isEmpty() ? 0 : stack.peek() + 1; i < n; i++) {
            stack.push(i);
            combination(combination, n, r, stack);
            stack.pop();
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String actual = "";
            String expected = "";
            System.out.printf("actual : %s | expected : %s" + System.lineSeparator(), actual, expected);
        }
    }
}
