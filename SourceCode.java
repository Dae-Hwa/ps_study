import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = Arrays.copyOf(arr1, arr1.length);

        for (int i = 0; i < answer.length; i++) {
            int[] row = answer[i];
            for (int j = 0; j < row.length; j++) {
                answer[i][j] += arr2[i][j];
            }
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[][]{
                                {1, 2},
                                {2, 3}
                        },
                        new int[][]{
                                {3, 4},
                                {5, 6}
                        }
                },
                new Object[]{
                        new int[][]{
                                {1},
                                {2}
                        },
                        new int[][]{
                                {3},
                                {4}
                        }
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[][] result = new Solution().solution((int[][]) arguments[0], (int[][]) arguments[1]);

            System.out.println(Arrays.deepToString(result));
        }
    }
}
