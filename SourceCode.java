import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        Deque<Dfs> dfs = new ArrayDeque<>();
        dfs.push(new Dfs(numbers));

        while (!dfs.isEmpty()) {
            Dfs cur = dfs.pop();

            if (cur.hasNext()) {
                dfs.push(cur.nextPositive());
                dfs.push(cur.nextNegative());
            } else {
                if (cur.result() == target) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

class Dfs {
    private int[] numbers;
    private int number;
    private int count;

    public Dfs(int[] numbers) {
        this(numbers, 0, -1);
    }

    public Dfs(int[] numbers, int number, int count) {
        this.numbers = numbers;
        this.number = number;
        this.count = count;
    }

    public boolean hasNext() {
        return count + 1 < numbers.length;
    }

    public Dfs nextPositive() {
        return nextWith(number + numbers[count + 1]);
    }

    public Dfs nextNegative() {
        return nextWith(number - numbers[count + 1]);
    }

    private Dfs nextWith(int number) {
        return new Dfs(numbers, number, count + 1);
    }

    public int result() {
        return number;
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
