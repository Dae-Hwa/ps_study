import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        Deque<Integer> numbers = Arrays.stream(s.split(" "))
                                        .map(Integer::parseInt)
                                        .sorted()
                                        .collect(Collectors.toCollection(ArrayDeque::new));

        return numbers.peekFirst() + " " + numbers.peekLast();
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{"1 2 3 4"},
                new Object[]{"-1 -2 -3 -4"},
                new Object[]{"-1 -1"}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String result = new Solution().solution((String) arguments[0]);

            System.out.println(result);
        }
    }
}
