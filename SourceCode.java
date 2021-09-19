import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] solutions = Stream.of(br.readLine().split(" "))
                                .mapToInt(Integer::valueOf)
                                .sorted()
                                .toArray();

        int[] answer = solution(solutions);

        System.out.println(
                Arrays.stream(answer)
                      .mapToObj(String::valueOf)
                      .collect(Collectors.joining(" "))
        );
    }

    static int[] solution(int[] solutions) {
        int minValue = Integer.MAX_VALUE;
        int[] answer = new int[2];

        int left = 0;
        int right = solutions.length - 1;

        while (left < right) {
            int sum = Math.abs(solutions[left] + solutions[right]);

            if (Math.abs(sum) < minValue) {
                minValue = sum;
                answer[0] = solutions[left];
                answer[1] = solutions[right];
            }

            if (Math.abs(solutions[left + 1] + solutions[right]) < Math.abs(solutions[left] + solutions[right - 1])) {
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[]{-99, -2, -1, 4, 98},
                        new int[]{-99, 98}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String actual = Arrays.toString(Main.solution((int[]) arguments[0]));
            String expected = Arrays.toString((int[]) arguments[1]);
            System.out.printf("actual : %s | expected : %s" + System.lineSeparator(), actual, expected);
        }
    }
}
