import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] universities = new Node[n];

        int remains = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            remains = Math.max(d, remains);

            universities[i] = new Node(p, d);
        }

        Arrays.sort(universities, (o1, o2) -> Comparator.<Integer>reverseOrder().compare(o1.p, o2.p));

        int[] temp = new int[remains + 1];
        for (int i = 0; i < universities.length; i++) {
            Node cur = universities[i];

            if (temp[cur.d] == 0) {
                temp[cur.d] = cur.p;
            } else {
                int min = 1;
                for (int j = 1; j <= cur.d; j++) {
                    if (temp[j] <= temp[min]) {
                        min = j;
                    }
                }
                if (temp[min] < cur.p) {
                    temp[min] = cur.p;
                }
            }
        }

        System.out.println(Arrays.stream(temp).sum());
    }

    static class Node {
        int p;
        int d;

        public Node(int p, int d) {
            this.p = p;
            this.d = d;
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
