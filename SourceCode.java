import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        System.out.println(solution(N, K));
    }

    public static int solution(int N, int K) {
        if (K == 1) return 1;

        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();

        int cnt = 0;
        for (int i = 1; i <= N / i; i++) {
            if (N % i == 0) {
                left.add(i);
                if (i != N / i) right.add(0, N / i);
                cnt++;
            }

            if (cnt == K) {
                return i;
            }
        }

        int leftSize = left.size();

        if (leftSize + right.size() < K) {
            return 0;
        }

        return right.get(K - 1 - leftSize);
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{6, 3},
                new Object[]{25, 4},
                new Object[]{2735, 1}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int result = Main.solution((int) arguments[0], (int) arguments[1]);

            System.out.println(result);
        }
    }
}
