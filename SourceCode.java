import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int H = Integer.parseInt(input1[1]);

        int[] fromTop = new int[H];
        int[] fromBottom = new int[H];

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                fromBottom[H - cur]++;
            } else {
                fromTop[H - cur]++;
            }
        }

        int[] cave = new int[H];

//        System.out.println(Arrays.toString(fromTop));
//        System.out.println(Arrays.toString(fromBottom));

        for (int i = 0; i < H - 1; i++) {
            fromTop[i + 1] += fromTop[i];
            fromBottom[i + 1] += fromBottom[i];
        }

//        System.out.println(Arrays.toString(fromTop));
//        System.out.println(Arrays.toString(fromBottom));

        for (int i = 0; i < H; i++) {
            int reverse = H - i - 1;
            cave[i] = fromTop[reverse] + fromBottom[i];
        }

//        System.out.println(Arrays.toString(cave));

        Arrays.sort(cave);

        int min = cave[0];
        int minCount = 0;

        for (int i = 0; i < cave.length; i++) {
            if (cave[i] == min) {
                minCount++;
            } else {
                break;
            }
        }

        System.out.println(min + " " + minCount);
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
