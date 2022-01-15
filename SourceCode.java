import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stores = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::valueOf)
                             .toArray();

        int max = 0;
        int cur = 2;

        for (var each : stores) {
            if ((each == 0 && cur == 2) ||
                (each == 1 && cur == 0) ||
                (each == 2 && cur == 1)
            ) {
                cur = each;
                max++;
            }
        }

        System.out.println(max);
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
