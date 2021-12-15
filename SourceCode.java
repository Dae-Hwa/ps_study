import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] eatingTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] heatingTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Integer[] lookup = new Integer[n];

        for (int i = 0; i < n; i++) {
            lookup[i] = i;
        }

        Arrays.sort(
                lookup,
                Comparator.comparingInt((Integer value) -> eatingTime[value])
                          .reversed()
        );

        int time = 0;
        int endTime = 0;

        for (int i = 0; i < n; i++) {
            time += heatingTime[lookup[i]];
            endTime--;
            endTime = Math.max(endTime, eatingTime[lookup[i]]);
        }

        System.out.println(time + endTime);
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
