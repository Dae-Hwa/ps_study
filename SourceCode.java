import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[][] maps) {
        int maxX = maps.length;
        int maxY = maps[0].length;

        boolean[][] visited = new boolean[maxX][maxY];

        Deque<int[]> bfs = new ArrayDeque<>();
        bfs.offer(new int[]{0, 0, 0});

        int[] dX = new int[]{1, -1, 0, 0};
        int[] dY = new int[]{0, 0, 1, -1};

        int minCount = Integer.MAX_VALUE;

        while (!bfs.isEmpty()) {
            int[] cur = bfs.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCnt = cur[2];

            if (visited[curX][curY]) continue;

            curCnt++;

            if (curX == maxX - 1 && curY == maxY - 1 && curCnt < minCount) {
                minCount = curCnt;
                continue;
            }

            visited[curX][curY] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dX[i];
                int nextY = curY + dY[i];

                if (0 <= nextX &&
                    0 <= nextY &&
                    nextX < maxX &&
                    nextY < maxY &&
                    maps[nextX][nextY] == 1 &&
                    !visited[nextX][nextY]
                ) {
                    bfs.offer(new int[]{nextX, nextY, curCnt});
                }
            }
        }


        return minCount != Integer.MAX_VALUE ? minCount : -1;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[][]{
                                {1, 0, 1, 1, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1},
                                {1, 1, 1, 0, 1},
                                {0, 0, 0, 0, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {1, 0, 1, 1, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1},
                                {1, 1, 1, 0, 0},
                                {0, 0, 0, 0, 1}
                        }
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int[][]) arguments[0]));
        }
    }
}
