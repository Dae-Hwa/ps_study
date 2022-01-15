import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        var N = Integer.parseInt(br.readLine());
        int[] stores = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::valueOf)
                             .toArray();

        Deque<Node> visits = new ArrayDeque<>();
        var start = new Node(
                stores,
                -1,
                2,
                0
        );
        visits.push(start);

        var max = 0;
        while (!visits.isEmpty()) {
            var cur = visits.pop();
            max = Math.max(cur.count, max);

            var forNotBuying = cur.next();
            if (forNotBuying.notBuy()) {
                visits.push(forNotBuying);
            }

            var forBuying = cur.next();
            if (forBuying.buy()) {
                visits.push(forBuying);
            }
        }

        System.out.println(max);
    }
}

class Node {
    int[] stores;
    int index;
    int prev;
    int count;

    public Node(
            int[] stores,
            int index,
            int prev,
            int count
    ) {
        this.stores = stores;
        this.index = index;
        this.prev = prev;
        this.count = count;
    }

    public Node next() {
        return new Node(
                stores,
                index + 1,
                prev,
                count
        );
    }

    public boolean buy() {
        if (stores.length <= index) {
            return false;
        }

        if (stores[index] - prev != 1 &&
            stores[index] - prev != -2 &&
            prev != -1
        ) {
            return false;
        }

        prev = stores[index];
        count++;

        return true;
    }

    public boolean notBuy() {
        if (stores.length <= index) {
            return false;
        }

        return true;
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
