import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);

        int[] children = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int[] costs = new int[N - 1];

        for (int i = 0; i < children.length - 1; i++) {
            costs[i] = children[i + 1] - children[i];
        }

        Arrays.sort(costs);

        int answer = 0;

        for (int i = 0; i < N - K; i++) {
            answer += costs[i];
        }

        System.out.println(answer);
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
