import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static final int N = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[N][];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        Set<List<Integer>> zeros = new HashSet<>();
        int og = 0;

        for (int i = 0; i < N; i++) {
            int horizon = 0;
            int vertical = 0;

            boolean horizonFlag = false;
            boolean verticalFlag = false;

            for (int j = 0; j < N; j++) {
                horizon += board[i][j];
                vertical += board[j][i];

                if (board[i][j] == 0) {
                    zeros.add(List.of(i, j));
                    horizonFlag = true;
                }
                if (board[j][i] == 0) {
                    verticalFlag = true;
                    zeros.add(List.of(j, i));
                }
            }

            if (!horizonFlag) {
                og = Math.max(og, horizon);
            }

            if (!verticalFlag) {
                og = Math.max(og, vertical);
            }
        }

        if (og == 0) {
            og = (Arrays.stream(board)
                        .flatMapToInt(ints -> Arrays.stream(ints))
                        .sum()) / 2;
        }

        while (!zeros.isEmpty()) {
            List<List<Integer>> toBeRemove = new ArrayList<>();
            for (List<Integer> zero : zeros) {
                int horizon = 0;
                int vertical = 0;

                int horizonFlag = 0;
                int verticalFlag = 0;

                int h = zero.get(0);
                int v = zero.get(1);

                for (int i = h; i < h + N; i++) {
                    int x = i % N;
                    int y = v;

                    horizon += board[x][y];

                    if (board[x][y] == 0) {
                        horizonFlag++;
                    }
                }

                for (int i = h; i < h + N; i++) {
                    int x = h;
                    int y = i % N;

                    vertical += board[x][y];

                    if (board[x][y] == 0) {
                        verticalFlag++;
                    }
                }

                if (horizonFlag == 1) {
                    board[h][v] = og - horizon;
                } else if (verticalFlag == 1) {
                    board[h][v] = og - vertical;
                } else {
                    continue;
                }

                toBeRemove.add(zero);
            }

            zeros.removeAll(toBeRemove);
        }

        for (int[] r : board) {
            StringJoiner sj = new StringJoiner(" ");

            for (int c : r) {
                sj.add(String.valueOf(c));
            }

            System.out.println(sj);
        }
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
