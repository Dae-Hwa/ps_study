import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int boardSize = game_board.length;

        List<Block> boardsToBeFilled = new ArrayList<>();
        List<Block> blocks = new ArrayList<>();
        boolean[][] boardVisited = new boolean[boardSize][boardSize];
        boolean[][] blockVisited = new boolean[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {

                Coordinate coordinate = new Coordinate(i, j);
                if (!boardVisited[i][j] && game_board[i][j] == 0) {
                    boardsToBeFilled.add(findBlock(
                            game_board,
                            coordinate,
                            0,
                            boardVisited));
                }

                if (!blockVisited[i][j] && table[i][j] == 1) {
                    blocks.add(findBlock(
                            table,
                            coordinate,
                            1,
                            blockVisited));
                }
            }
        }

        Collections.sort(boardsToBeFilled);
        Collections.sort(blocks);

        int answer = 0;

        for (Block frame : boardsToBeFilled) {
            for (int i = 0; i < blocks.size(); i++) {
                if (frame.coordinates.size() < blocks.get(i).coordinates.size()) {
                    break;
                }

                if (blocks.get(i).coordinates.size() < frame.coordinates.size()) {
                    blocks.remove(i);
                    i--;
                    continue;
                }

                if (checkBlock(frame, blocks.get(i))) {
                    answer += blocks.get(i).coordinates.size();
                    blocks.remove(i);
                    i--;
                    break;
                }
            }
        }

        return answer;
    }

    private Block findBlock(int[][] boards, Coordinate coordinate, int block, boolean[][] visited) {
        Deque<Dfs> dfs = new ArrayDeque<>();
        Set<Coordinate> visitedBlocks = new HashSet<>();
        dfs.push(new Dfs(coordinate, visitedBlocks));
        visitedBlocks.add(coordinate);
        visited[coordinate.x][coordinate.y] = true;

        while (!dfs.isEmpty()) {
            Dfs cur = dfs.pop();

            List<Coordinate> nexts = cur.coordinate.next(boards.length);
            for (Coordinate next : nexts) {
                if (boards[next.x][next.y] == block && cur.add(next)) {
                    dfs.push(cur.next(next));
                    visited[next.x][next.y] = true;
                }
            }
        }

        return new Block(new ArrayList<>(visitedBlocks));
    }

    private boolean checkBlock(Block frame, Block block) {

        int[][] defaultFrame = createBlock(frame.coordinates);
        int[][] blockToFill = createBlock(block.coordinates);

        int boardSize = 16;
        int offset = 5;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                for (int rotation = 0; rotation < 4; rotation++) {
                    int[][] board = new int[boardSize][boardSize];

                    for (int k = 0; k < 6; k++) {
                        for (int l = 0; l < 6; l++) {
                            board[k + offset][l + offset] = defaultFrame[k][l];
                        }
                    }

                    for (int l = 0; l < 6; l++) {
                        for (int m = 0; m < 6; m++) {
                            if (rotation == 0) {
                                board[i + l][j + m] += blockToFill[l][m];
                            } else if (rotation == 1) {
                                board[i + l][j + m] += blockToFill[5 - m][l];
                            } else if (rotation == 2) {
                                board[i + l][j + m] += blockToFill[5 - l][5 - m];
                            } else if (rotation == 3) {
                                board[i + l][j + m] += blockToFill[m][5 - l];
                            }

                        }
                    }

                    int cnt = 0;
                    for (int k = 0; k < boardSize; k++) {
                        for (int l = 0; l < boardSize; l++) {
                            if (board[k][l] == 2) {
                                cnt++;
                            } else if (board[k][l] == 1) {
                                cnt = -1;
                                break;
                            }
                        }
                        if (cnt == -1) {
                            break;
                        }
                    }
                    if (cnt == frame.coordinates.size()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[][] createBlock(List<Coordinate> coordinates) {
        int[][] block = new int[6][6];
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;

        for (Coordinate coordinate : coordinates) {
            minX = Math.min(coordinate.x, minX);
            minY = Math.min(coordinate.y, minY);
            maxX = Math.max(coordinate.x, maxX);
            maxY = Math.max(coordinate.y, maxY);
        }

        for (Coordinate coordinate : coordinates) {
            block[coordinate.x - minX][coordinate.y - minY] = 1;
        }

        return block;
    }
}

class Dfs {
    Coordinate coordinate;
    Set<Coordinate> visitedBlocks;

    public Dfs(Coordinate coordinate, Set<Coordinate> visitedBlocks) {
        this.coordinate = coordinate;
        this.visitedBlocks = visitedBlocks;
    }

    public boolean add(Coordinate coordinate) {
        return visitedBlocks.add(coordinate);
    }

    public Dfs next(Coordinate coordinate) {
        return new Dfs(coordinate, visitedBlocks);
    }
}

class Block implements Comparable<Block> {
    List<Coordinate> coordinates;

    public Block(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public int compareTo(Block o) {
        return Integer.compare(coordinates.size(), o.coordinates.size());
    }
}

class Coordinate {
    private static final int[][] next = new int[][]{
            {1, -1, 0, 0},
            {0, 0, 1, -1}
    };

    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Coordinate> next(int max) {
        List<Coordinate> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nextX = x + next[0][i];
            int nextY = y + next[1][i];
            if (checkNext(nextX, max) && checkNext(nextY, max)) {
                result.add(new Coordinate(nextX, nextY));
            }
        }

        return result;
    }

    private boolean checkNext(int next, int max) {
        return 0 <= next && next < max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y) + Objects.hash(y, x);
    }

    public String toString() {
        return "x : " + x + ", y : " + y;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[][]{
                                {1, 1, 0, 0, 1, 0},
                                {0, 0, 1, 0, 1, 0},
                                {0, 1, 1, 0, 0, 1},
                                {1, 1, 0, 1, 1, 1},
                                {1, 0, 0, 0, 1, 0},
                                {0, 1, 1, 1, 0, 0}
                        },
                        new int[][]{
                                {1, 0, 0, 1, 1, 0},
                                {1, 0, 1, 0, 1, 0},
                                {0, 1, 1, 0, 1, 1},
                                {0, 0, 1, 0, 0, 0},
                                {1, 1, 0, 1, 1, 0},
                                {0, 1, 0, 0, 0, 0}
                        },
                        14
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String actual = String.valueOf(new Solution().solution((int[][]) arguments[0], (int[][]) arguments[1]));
            String expected = String.valueOf(arguments[2]);
            System.out.printf("actual : %s | expected : %s" + System.lineSeparator(), actual, expected);
        }
    }
}
