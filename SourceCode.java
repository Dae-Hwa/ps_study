import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int rowLength = 4;
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < rowLength; j++) {
                int curMax = 0;
                for (int k = 0; k < rowLength; k++) {
                    int cur = land[i][j] + land[i - 1][k];
                    if (j != k && curMax < cur) {
                        curMax = cur;
                    }
                }
                land[i][j] = curMax;
            }
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{new int[][]{
                        {1, 2, 3, 5},
                        {5, 6, 7, 8},
                        {4, 3, 2, 1}
                }}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int result = new Solution().solution((int[][]) arguments[0]);

            System.out.println(result);
        }
    }
}
