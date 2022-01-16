import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] universities = new Node[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);

            universities[i] = new Node(p, d);
        }

        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.p, o2.p) * -1);
        pq.addAll(Arrays.asList(universities));

        int remains = 0;
        for (Node each : universities) {
            remains = Math.max(each.d, remains);
        }

        int[] temp = new int[remains + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

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
