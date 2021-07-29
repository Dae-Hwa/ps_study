import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int nextDeploymentIndex = 0;
        int numberOfProgresses = progresses.length;
        Deque<Integer> resultQueue = new ArrayDeque<>();

        while (nextDeploymentIndex < numberOfProgresses) {
            int currentDeployIndex = nextDeploymentIndex;

            for (int i = nextDeploymentIndex; i < numberOfProgresses; i++) {
                progresses[i] += speeds[i];

                if (i == currentDeployIndex && 100 <= progresses[i]) {
                    currentDeployIndex++;
                }
            }

            if (nextDeploymentIndex < currentDeployIndex) {
                resultQueue.offerLast(currentDeployIndex - nextDeploymentIndex);
                nextDeploymentIndex = currentDeployIndex;
            }
        }

        return resultQueue.stream().mapToInt(Integer::valueOf).toArray();
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[]{93, 30, 55},
                        new int[]{1, 30, 5}
                },
                new Object[]{
                        new int[]{95, 90, 99, 99, 80, 99},
                        new int[]{1, 1, 1, 1, 1, 1}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().solution((int[]) arguments[0], (int[]) arguments[1]);

            System.out.println(Arrays.toString(result));
        }
    }
}
