import java.util.*;
import java.util.stream.*;

class Solution {
    private void init (List<Node> tables, int n) {
        Node start = new Node(0);
        tables.add(start);
        Node prev = start;

        for (int i = 1; i < n; i++) {
            Node cur = new Node(i);
            tables.add(cur);
            cur.prev( prev);
            prev.next (cur);
            prev = cur;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        List<Node> tables = new ArrayList<>(n);
        init(tables, n);

        Deque<Node> stack = new ArrayDeque<>();

        Node currentNode = tables.get(k);
        for (String each : cmd) {
            String[] command = each.split(" ");
            if (command[0].equals("C")) {
                currentNode.delete();
                stack.push(currentNode);
                currentNode = currentNode.hasNext() ? currentNode.next() : currentNode.prev();
            } else if (command[0].equals("Z")) {
                Node restored = stack.pop();
                restored.restore();
            } else {
                int distance = Integer.parseInt(command[1]);

                if (command[0].equals("U")) {
                    for (int i = 0; i < distance; i++) {
                        currentNode = currentNode.prev();
                    }
                } else if (command[0].equals("D")) {
                    for (int i = 0; i < distance; i++) {
                        currentNode = currentNode.next();
                    }
                }
            }
        }
        return tables.stream()
                     .map(node -> node.isDeleted() ? "X" : "O")
                     .collect(Collectors.joining());
    }
}

class Node {
    private int id;
    private boolean isDeleted;
    private Node prev;
    private Node next;

    public Node(int id) {
        this.id = id;
    }

    public boolean hasPrev() {
        return prev != null;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Node prev() {
        return prev;
    }

    public void prev(Node prev) {
        this.prev = prev;
    }

    public Node next() {
        return next;
    }

    public void next(Node next) {
        this.next = next;
    }

    public void delete() {
        isDeleted = true;

        if (hasPrev()) {
            prev.next(next);
        }
        if (hasNext()) {
            next.prev(prev);
        }
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void restore() {
        isDeleted = false;
        if (hasPrev()) {
            prev.next(this);
        }

        if (hasNext()) {
            next.prev(this);
        }
    }

    @Override
    public String toString() {
        return "id : " + id + isDeleted;
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
