import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");

        int R = Integer.parseInt(input1[0]);
        int C = Integer.parseInt(input1[1]);

        char[][] board = new char[R][];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[] commands = Arrays.stream(br.readLine().split(""))
                               .mapToInt(Integer::parseInt)
                               .toArray();

        int[][] nexts = new int[][]{
                {1, -1},
                {1, 0},
                {1, 1},
                {0, -1},
                {0, 0},
                {0, 1},
                {-1, -1},
                {-1, 0},
                {-1, 1}
        };

        Node I = new Node(-1, -1);
        List<Node> robots = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'I') {
                    I = new Node(i, j);
                }
                if (board[i][j] == 'R') {
                    robots.add(new Node(i, j));
                }
            }
        }

        int cnt = 0;
        for (int command : commands) {
            cnt++;
            I.x += nexts[command - 1][0];
            I.y += nexts[command - 1][1];

            if (I.isCaughtBy(robots)) {
                printEndMessage(cnt);
                return;
            }

            Set<Node> movedRobots = new HashSet<>();
            List<Node> robotsWillBeRemoved = new ArrayList<>();

            for (int i = 0; i < robots.size(); i++) {
                Node robot = robots.get(i);

                Node min = robot;
                for (int[] next : nexts) {
                    Node candidate = new Node(robot.x + next[0], robot.y + next[1]);
                    if (distanceOf(I, candidate) < distanceOf(I, min)) {
                        min = candidate;
                    }
                }


                robot.x = min.x;
                robot.y = min.y;

                if (I.isCaughtBy(robots)) {
                    printEndMessage(cnt);
                    return;
                }

                if (!movedRobots.add(robot)) {
                    robotsWillBeRemoved.add(robot);
                }
            }

            robots.removeAll(robotsWillBeRemoved);
        }

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        board[I.x][I.y] = 'I';
        for (Node robot : robots) {
            board[robot.x][robot.y] = 'R';
        }

        StringBuilder sb = new StringBuilder();

        for (char[] row : board) {
            for (char column : row) {
                sb.append(column);
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static int distanceOf(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private static void printEndMessage(int cnt) {
        System.out.println("kraj " + cnt);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isCaughtBy(List<Node> robots) {
        return robots.contains(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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
