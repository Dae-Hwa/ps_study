import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int X = Integer.parseInt(input1[1]);
        int[] orders = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::valueOf)
                             .toArray();

        System.out.println(calculateMinimumAssemblyLineSize(X, orders));

    }

    static int calculateMinimumAssemblyLineSize(int timeLimit, int[] orders) {
        int left = 1;
        int right = orders.length - 1;
        int minimumSize = orders.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            Queue<Integer> assemblyLines = new PriorityQueue<>();

            for (int i = 0; i < mid; i++) {
                assemblyLines.offer(orders[i]);
            }

            for (int i = mid; i < orders.length; i++) {
                assemblyLines.offer(assemblyLines.poll() + orders[i]);
            }

            // 시간초과나면 최적화
            int currentMaxTime = assemblyLines.stream()
                                              .mapToInt(Integer::valueOf)
                                              .max()
                                              .getAsInt();

            if (currentMaxTime <= timeLimit) {
                minimumSize = Math.min(minimumSize, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minimumSize;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        11,
                        new int[]{5, 2, 8, 4, 3, 5},
                        3
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String actual = String.valueOf(Main.calculateMinimumAssemblyLineSize((int) arguments[0], (int[]) arguments[1]));
            String expected = String.valueOf(arguments[2]);
            System.out.printf("actual : %s | expected : %s" + System.lineSeparator(), actual, expected);
        }
    }
}
