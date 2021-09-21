import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]); // 학생 수
        int D = Integer.parseInt(input1[1]); // 문제 종류(개수)
        int K = Integer.parseInt(input1[2]); // 최대 가짓수

        int[][] students = new int[N][];

        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            int numberOfProblemCanSolve = Integer.parseInt(input2[0]);

            int[] student = new int[numberOfProblemCanSolve];

            for (int j = 0; j < numberOfProblemCanSolve; j++) {
                student[j] = Integer.parseInt(input2[j + 1]);
            }

            students[i] = student;
        }

        System.out.println(solution(D, K, students));
    }

    static int solution(int D, int K, int[][] students) {
        List<List<Integer>> combination = combination(D, K);

        int maxStudent = 0;

        for (List<Integer> each : combination) {
            int numberOfStudent = 0;
            for (int[] student : students) {
                if (student.length == 0) {
                    numberOfStudent++;
                    continue;
                }

                int cnt = 0;
                for (int problem : student) {
                    if (each.contains(problem)) {
                        cnt++;
                    }
                }

                if (cnt < student.length || cnt == 0) {
                    continue;
                }

                numberOfStudent++;
            }

            maxStudent = Math.max(maxStudent, numberOfStudent);
        }

        return maxStudent;
    }

    private static List<List<Integer>> combination(int n, int r) {
        List<List<Integer>> combination = new ArrayList<>();
        combination(combination, n, r, new ArrayDeque<>());
        return combination;
    }

    private static void combination(List<List<Integer>> combination, int n, int r, Deque<Integer> stack) {
        if (stack.size() == r) {
            combination.add(new ArrayList<>(stack));
            return;
        }

        for (int i = stack.isEmpty() ? 1 : stack.peek() + 1; i <= n; i++) {
            stack.push(i);
            combination(combination, n, r, stack);
            stack.pop();
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        3,
                        2,
                        new int[][]{{}, {1}, {2}, {3}, {2, 1}, {2, 1}},
                        5
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String actual = String.valueOf(Main.solution((int) arguments[0], (int) arguments[1], (int[][]) arguments[2]));
            String expected = String.valueOf(arguments[3]);
            System.out.printf("actual : %s | expected : %s" + System.lineSeparator(), actual, expected);
        }
    }
}
