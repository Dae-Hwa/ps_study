import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    private static final char[] LOOKUP = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static List<List<Character>> permutations = permutations(8, 8);

    public int solution(int n, String[] data) {
        int answer = 0;

        for (List<Character> permutation : permutations) {
            if (isAcceptable(data, permutation)) answer++;
        }

        return answer;
    }

    private boolean isAcceptable(String[] data, List<Character> permutation) {
        for (String each : data) {
            char[] query = each.toCharArray();
            int left = permutation.indexOf(query[0]);
            int right = permutation.indexOf(query[2]);
            char command = query[3];
            int expectedDistance = Character.digit(query[4], 10);

            int actualDistance = Math.abs(left - right) - 1;

            switch (command) {
                case '=': {
                    if (!(actualDistance == expectedDistance)) {
                        return false;
                    }
                    break;
                }
                case '<': {
                    if (!(actualDistance < expectedDistance)) {
                        return false;
                    }
                    break;
                }
                case '>': {
                    if (!(expectedDistance < actualDistance)) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }

    private static List<List<Character>> permutations(int n, int r) {
        List<List<Character>> permutations = new ArrayList<>();
        calculatePermutations(n, r, permutations, new ArrayDeque<>());
        return permutations;
    }

    private static void calculatePermutations(int n, int r, List<List<Character>> permutations, Deque<Character> stack) {
        if (stack.size() == r) {
            permutations.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (stack.contains(LOOKUP[i])) continue;

            stack.push(LOOKUP[i]);
            calculatePermutations(n, r, permutations, stack);
            stack.pop();
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{2, new String[]{"N~F=0", "R~T>2"}},
                new Object[]{2, new String[]{"M~C<2", "C~M>1"}}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int) arguments[0], (String[]) arguments[1]));
        }
    }
}
