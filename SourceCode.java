import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            List<Integer> A = Stream.of(br.readLine().split(" "))
                                    .map(Integer::valueOf)
                                    .collect(Collectors.toList());

            List<Integer> B = Stream.of(br.readLine().split(" "))
                                    .map(Integer::valueOf)
                                    .sorted()
                                    .collect(Collectors.toList());

            System.out.println(solution(A, B));
        }
    }

    static int solution(List<Integer> A, List<Integer> B) {
        int answer = 0;

        for (int a : A) {
            int left = 0;
            int right = B.size() - 1;
            int count = 0;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (B.get(mid) < a) {
                    left = mid + 1;

                    count = Math.max(mid + 1, count);
                } else {
                    right = mid - 1;
                }
            }

            answer += count;
        }


        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new ArrayList<>(List.of(8, 7, 3, 1, 1)),
                        new ArrayList<>(List.of(1, 3, 6)),
                        7
                },
                new Object[]{
                        new ArrayList<>(List.of(13, 7, 2)),
                        new ArrayList<>(List.of(11, 103, 215, 290)),
                        1
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String actual = String.valueOf(Main.solution((List<Integer>) arguments[0], (List<Integer>) arguments[1]));
            String expected = String.valueOf(arguments[2]);
            System.out.printf("actual : %s | expected : %s" + System.lineSeparator(), actual, expected);
        }
    }
}
