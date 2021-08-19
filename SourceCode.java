import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> result = new ArrayList<>();

        while (true) {
            String firstLine = br.readLine();
            if (firstLine.equals("0 0")) break;

            String[] splitFirstLine = firstLine.split(" ");

            int w = Integer.parseInt(splitFirstLine[0]);
            int h = Integer.parseInt(splitFirstLine[1]);

            int[][] map = new int[h][w];

            for (int i = 0; i < h; i++) {
                map[i] = Arrays.stream(br.readLine().split(" "))
                               .mapToInt(Integer::valueOf)
                               .toArray();
            }

            result.add(calculateNumberOfMap(map));
        }

        System.out.println(
                result.stream()
                      .map(String::valueOf)
                      .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    static int calculateNumberOfMap(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Deque<int[]> bfs = new ArrayDeque<>();
        int[] dX = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
        int[] dY = new int[]{0, 0, 1, -1, 1, -1, -1, 1};


        int numberOfIsland = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                bfs.offer(new int[]{i, j});

                if (!visited[i][j] && map[i][j] == 1) numberOfIsland++;

                while (!bfs.isEmpty()) {
                    int[] cur = bfs.poll();

                    int curX = cur[0];
                    int curY = cur[1];

                    if (visited[curX][curY] || map[curX][curY] == 0) continue;
                    visited[curX][curY] = true;

                    for (int k = 0; k < 8; k++) {
                        int nextX = curX + dX[k];
                        int nextY = curY + dY[k];

                        if (0 <= nextX && 0 <= nextY && nextX < map.length && nextY < map[0].length) {
                            if (visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                            bfs.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }

        return numberOfIsland;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[][]{
                                {0}
                        }
                },
                new Object[]{
                        new int[][]{
                                {0, 1},
                                {1, 0}
                        }
                },
                new Object[]{
                        new int[][]{
                                {1, 1, 1},
                                {1, 1, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {1, 0, 1, 0, 0},
                                {1, 0, 0, 0, 0},
                                {1, 0, 1, 0, 1},
                                {1, 0, 0, 1, 0}
                        }
                },
                new Object[]{
                        new int[][]{
                                {1, 1, 1, 0, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {1, 0, 1, 0, 1},
                                {0, 0, 0, 0, 0},
                                {1, 0, 1, 0, 1},
                                {0, 0, 0, 0, 0},
                                {1, 0, 1, 0, 1}
                        }
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(Main.calculateNumberOfMap((int[][]) arguments[0]));
        }
    }
}
