import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int[] dX = new int[]{1, -1, 0, 0};
        int[] dY = new int[]{0, 0, 1, -1};

        boolean[][] visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || picture[i][j] == 0) continue;

                numberOfArea++;

                Deque<int[]> bfs = new ArrayDeque<>();
                bfs.offer(new int[]{i, j});

                int curWidth = 0;

                while (!bfs.isEmpty()) {
                    int[] coordinate = bfs.poll();
                    int curX = coordinate[0];
                    int curY = coordinate[1];

                    if (picture[i][j] != picture[curX][curY] || visited[curX][curY]) continue;

                    visited[curX][curY] = true;
                    curWidth++;

                    for (int k = 0; k < 4; k++) {
                        int nextX = curX + dX[k];
                        int nextY = curY + dY[k];

                        if (0 <= nextX && 0 <= nextY && nextX < m && nextY < n && !visited[nextX][nextY]) {
                            bfs.offer(new int[]{nextX, nextY});
                        }
                    }
                }

                if (maxSizeOfOneArea < curWidth) maxSizeOfOneArea = curWidth;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
//                new Object[]{
//                        6,
//                        4,
//                        new int[][]{
//                                {1, 1, 1, 0},
//                                {1, 2, 2, 0},
//                                {1, 0, 0, 1},
//                                {0, 0, 0, 1},
//                                {0, 0, 0, 3},
//                                {0, 0, 0, 3}
//                        }
//                },
                new Object[]{
                        6,
                        4,
                        new int[][]{
                                {1, 1, 1, 0},
                                {1, 1, 1, 0},
                                {0, 0, 0, 1},
                                {0, 0, 0, 1},
                                {0, 0, 0, 1},
                                {0, 0, 0, 1}
                        }
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().solution((int) arguments[0], (int) arguments[1], (int[][]) arguments[2]);

            System.out.println(Arrays.toString(result));
        }
    }
}
