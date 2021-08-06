import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfRealDivisor = Integer.parseInt(br.readLine());
        int[] realDivisors = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();


        System.out.println(solution(realDivisors));
    }

    public static long solution(int[] realDivisors) {
        Arrays.sort(realDivisors);

        long N = realDivisors[realDivisors.length - 1] + 1;
        boolean isNotEnded = true;

        while (isNotEnded) {
            if (!isN(N, realDivisors)) {
                N++;
                continue;
            }

            isNotEnded = false;
        }

        return N;
    }

    private static boolean isN(long N, int[] realDivisors) {
        for (int realDivisor : realDivisors) {
            if (N % realDivisor != 0) {
                return false;
            }
        }

        int cnt = 0;

        for (int i = 1; i <= N / i; i++) {
            if (N % i == 0) {
                cnt++;

                if (N / i != i) cnt++;
            }
        }

        return cnt - 2 == realDivisors.length;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{new int[]{4, 2}},
                new Object[]{new int[]{2}},
                new Object[]{new int[]{3}},
                new Object[]{new int[]{2, 3}},
                new Object[]{new int[]{2, 4, 6, 3}},
                new Object[]{new int[]{7, 49, 343}}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            long result = Main.solution((int[]) arguments[0]);

            System.out.println(result);
        }
    }
}
