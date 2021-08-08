import java.util.Arrays;

class Solution {
    public int[] solution(int[][] arr) {
        int[] startingPoints = new int[]{0, arr.length};

        return quadZip(startingPoints, startingPoints, arr);
    }

    public int[] quadZip(int[] row, int[] column, int[][] arr) {
        int numberOfZero = 0;
        int numberOfOne = 0;

        for (int i = row[0]; i < row[1]; i++) {
            for (int j = column[0]; j < column[1]; j++) {
                if (arr[i][j] == 0) numberOfZero++;
                else numberOfOne++;
            }
        }

        if (numberOfZero == 0) return new int[]{0, 1};
        else if (numberOfOne == 0) return new int[]{1, 0};

        int[] result = new int[2];

        int nextLength = (row[1] - row[0]) / 2;

        for (int i = row[0]; i < row[1]; i += nextLength) {
            for (int j = column[0]; j < column[1]; j += nextLength) {
                int[] recursiveResult = quadZip(new int[]{i, i + nextLength}, new int[]{j, j + nextLength}, arr);
                result[0] += recursiveResult[0];
                result[1] += recursiveResult[1];
            }
        }

        return result;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[][]{
                                {1, 1, 0, 0},
                                {1, 0, 0, 0},
                                {1, 0, 0, 1},
                                {1, 1, 1, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 0, 0, 0, 1, 1, 1, 1},
                                {0, 1, 0, 0, 1, 1, 1, 1},
                                {0, 0, 0, 0, 0, 0, 1, 1},
                                {0, 0, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 1, 0, 0, 1},
                                {0, 0, 0, 0, 1, 1, 1, 1}
                        }
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().solution((int[][]) arguments[0]);

            System.out.println(Arrays.toString(result));
        }
    }
}
