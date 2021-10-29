import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int min = Integer.MAX_VALUE;

        int numberOfFriends = dist.length;
        int numberOfWeak = weak.length;

        int[][] rotations = new int[numberOfWeak][numberOfWeak];

        for (int i = 0; i < numberOfWeak; i++) {
            for (int j = 0; j < numberOfWeak - i; j++) {
                rotations[i][j] = weak[j + i];
            }

            for (int j = 0; j < i; j++) {
                rotations[i][j + numberOfWeak - i] = weak[j] + n;
            }
        }

        for (List<Integer> permutation : permutation(numberOfFriends, numberOfFriends)) {
            for (int[] rotation : rotations) {
                boolean[] visited = new boolean[numberOfWeak];

                int index = 0;
                int count = 0;

                for (int each : permutation) {
                    int maxDistance = rotation[index] + dist[each];

                    while (index < numberOfWeak && rotation[index] <= maxDistance) {
                        visited[index] = true;
                        index++;
                    }

                    count++;

                    if (index == numberOfWeak) {
                        break;
                    }
                }

                boolean flag = false;
                for (boolean isVisited : visited) {
                    if (!isVisited) {
                        flag = true;
                    }
                }

                if (flag) {
                    continue;
                }

                min = Math.min(min, count);
            }
        }

        return min != Integer.MAX_VALUE ? min : -1;
    }

    private List<List<Integer>> permutation(int n, int r) {
        List<List<Integer>> permutation = new ArrayList<>();
        permutation(n, r, permutation, new ArrayDeque<>());
        return permutation;
    }

    private void permutation(int n, int r, List<List<Integer>> permutation, Deque<Integer> stack) {
        if (stack.size() == r) {
            permutation.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < r; i++) {
            if (stack.contains(i)) {
                continue;
            }

            stack.push(i);
            permutation(n, r, permutation, stack);
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
