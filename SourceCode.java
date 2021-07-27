import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stocks = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            int curTime = prices.length - i - 1;
            answer[i] = curTime;

            while (!stocks.isEmpty() && prices[i] < prices[stocks.peek()]) {
                int droppedStock = stocks.pop();
                answer[droppedStock] -= curTime;
            }

            stocks.push(i);
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[]{1, 2, 3, 2, 3}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().solution((int[]) arguments[0]);

            System.out.println(Arrays.toString(result));
        }
    }
}
