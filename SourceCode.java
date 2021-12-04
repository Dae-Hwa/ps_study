import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int from = Integer.parseInt(br.readLine(), 2);
        int to = Integer.parseInt(br.readLine(), 2);

        Map<Integer, Integer> visited = new HashMap<>();

        Queue<Node> bfs = new ArrayDeque<>();
        Node start = new Node(from, 0);
        bfs.offer(start);

        while (!bfs.isEmpty()) {
            Node curNode = bfs.poll();

            int curNumber = curNode.number;
            if (curNumber == to) {
                System.out.println(curNode.count);
                return;
            }

            // 보수
            for (int i = 1; i << 1 <= curNumber; i <<= 1) {

                int nextNumber = curNumber ^ i;

                if (canMoveNext(visited, curNode, nextNumber)) {
                    Node nextNode = new Node(nextNumber, curNode.count + 1);
                    bfs.offer(nextNode);
                }
            }

            // 더하기
            int plus = curNumber + 1;
            if (canMoveNext(visited, curNode, plus)) {
                Node nextNode = new Node(plus, curNode.count + 1);
                bfs.offer(nextNode);
            }

            // 빼기
            if (curNumber == 0) {
                continue;
            }
            int minus = curNumber - 1;
            if (canMoveNext(visited, curNode, minus)) {
                Node nextNode = new Node(minus, curNode.count + 1);
                bfs.offer(nextNode);
            }
        }
    }

    private static boolean canMoveNext(Map<Integer, Integer> visited, Node curNode, int number) {
        int count = visited.getOrDefault(number, Integer.MAX_VALUE);
        if (curNode.count + 1 < count) {
            visited.put(number, curNode.count + 1);
            return true;
        }

        return false;
    }

    static class Node {
        public int number;
        public int count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
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
