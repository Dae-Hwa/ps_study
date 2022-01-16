import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int result = Integer.compare(Math.abs(o1), Math.abs(o2));

            if (result == 0) {
                return Integer.compare(o1, o2);
            }

            return result;
        });

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());

            if (cur == 0) {
                System.out.println(Objects.toString(pq.poll(), "0"));
            } else {
                pq.offer(cur);
            }
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
