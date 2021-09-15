import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            schedule[i][0] = Integer.parseInt(input[0]);
            schedule[i][1] = Integer.parseInt(input[1]);
        }

        System.out.println(solution(schedule));
    }

    public static int solution(int[][] schedule) {
        int N = schedule.length;
        int[] result = new int[N + 2];

        for (int i = 0; i < N; i++) {
            int Ti = schedule[i][0];
            int Pi = schedule[i][1];

            for (int nextDay = i + Ti; nextDay < N + 1; nextDay++) {
                result[nextDay] = Math.max(result[nextDay], result[i] + Pi);
            }

        }

        return Arrays.stream(result).max().getAsInt();
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[][]{{3, 10}, {5, 20}, {1, 10}, {1, 20}, {2, 15}, {4, 40}, {2, 200}},
                        45
                },
                new Object[]{
                        new int[][]{{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8}, {1, 9}, {1, 10}},
                        55
                },
                new Object[]{
                        new int[][]{{5, 10}, {5, 9}, {5, 8}, {5, 7}, {5, 6}, {5, 10}, {5, 9}, {5, 8}, {5, 7}, {5, 6}},
                        20
                },
                new Object[]{
                        new int[][]{{5, 50}, {4, 40}, {3, 30}, {2, 20}, {1, 10}, {1, 10}, {2, 20}, {3, 30}, {4, 40}, {5, 50}},
                        90
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String actual = String.valueOf(Main.solution((int[][]) arguments[0]));
            String expected = String.valueOf(arguments[1]);
            System.out.printf("actual : %s | expected : %s" + System.lineSeparator(), actual, expected);
        }
    }
}
