import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

class Main {

    private static final int N = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[N][];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        List<Node> zeros = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    zeros.add(new Node(i, j));
                }
            }
        }

        Node[] verticals = new Node[]{
                new Node(0, -1),
                new Node(-1, 0),
                new Node(0, 1),
                new Node(1, 0)
        };

        Node[] diagonals = new Node[]{
                new Node(-1, -1),
                new Node(-1, 1),
                new Node(1, -1),
                new Node(1, 1)
        };

        int sum = sumOfLine(board, verticals, diagonals);

        if (sum == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sum += board[i][j];
                }
            }
            sum /= 2;
        }

        int i = 0;
        while (!zeros.isEmpty()) {
            i = i % zeros.size();
            Node zero = zeros.get(i);

            boolean removed = fillZero(board, zeros, verticals, sum, i, zero);

            if (!removed && zero.canMoveToDiagonal()) {
                fillZero(board, zeros, diagonals, sum, i, zero);
            }
            i++;
        }

        for (int[] r : board) {
            StringJoiner sj = new StringJoiner(" ");

            for (int c : r) {
                sj.add(String.valueOf(c));
            }

            System.out.println(sj);
        }
    }

    private static boolean fillZero(int[][] board, List<Node> zeros, Node[] directions, int sum, int i, Node zero) {
        for (Node direction : directions) {

            boolean hasZero = false;
            int curSum = 0;
            for (int j = 1; j <= N - 1; j++) {
                int nextX = nextBy(zero.x, direction.x, j);
                int nextY = nextBy(zero.y, direction.y, j);
                int next = board[nextX][nextY];

                if (next == 0) {
                    hasZero = true;
                }
                curSum += next;
            }

            if (!hasZero && !zeros.isEmpty()) {
                board[zero.x][zero.y] = sum - curSum;
                zeros.remove(i);
                return true;
            }
        }

        return false;
    }

    private static int sumOfLine(int[][] board, Node[] verticals, Node[] diagonals) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                for (Node direction : verticals) {
                    int curSum = sum(i, j, board, direction);
                    if (curSum != 0) {
                        return curSum;
                    }
                }

                if (new Node(i, j).canMoveToDiagonal()) {
                    for (Node direction : diagonals) {
                        int curSum = sumD(i, j, board, direction);
                        if (curSum != 0) {
                            return curSum;
                        }
                    }
                }

            }
        }

        return 0;
    }

    private static int sum(int x, int y, int[][] board, Node direction) {
        int sum = 0;
        for (int k = 1; k <= N; k++) {
            int nextX = nextBy(x, direction.x, k);
            int nextY = nextBy(y, direction.y, k);
            int next = board[nextX][nextY];
            sum += next;

            if (next == 0) {
                return 0;
            }
        }

        return sum;
    }

    private static int sumD(int x, int y, int[][] board, Node direction) {
        int sum = 0;
        for (int k = 0; k < N; k++) {
            int nextX = x + direction.x * k;
            int nextY = y + direction.y * k;

            if (!(0 <= nextX && 0 <= nextY && nextX < 3 && nextY < 3)) {
                return 0;
            }

            int next = board[nextX][nextY];
            sum += next;

            if (next == 0) {
                return 0;
            }
        }

        return sum;
    }

    private static int nextBy(int cur, int next, int cnt) {
        return (cur + (next * cnt) + 3) % N;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean canMoveToDiagonal() {
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        if (absX == 1 && absY == 1) {
            return true;
        }

        return absX != 1 && absY != 1;
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
