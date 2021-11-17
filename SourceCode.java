import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] words) {
        int answer = 0;

        Trie trie = new Trie();

        for (String word : words) {
            trie.add(word);
        }

        for (String word : words) {
            answer += trie.find(word);
        }

        return answer;
    }
}

class Trie {
    private static final char END = 0;

    private Map<Character, Node> root = new HashMap<>();

    public void add(String word) {
        char rootKey = word.charAt(0);
        Node cur = root.getOrDefault(rootKey, new Node(rootKey));
        root.put(rootKey, cur);

        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            cur.add(c);
            cur = cur.get(c);
        }
        cur.add(END);
    }

    public int find(String target) {
        Node cur = root.get(target.charAt(0));
        int[] counter = new int[target.length()];

        for (int i = 1; i < target.length(); i++) {
            counter[i - 1] = cur.size();
            char c = target.charAt(i);
            cur = cur.get(c);
        }
        counter[counter.length - 1] = cur.size();

        int count = counter.length + 1;

        for (int i = counter.length - 1; 0 <= i && counter[i] <= 1; i--) {
            count--;
        }

        return Math.min(count, target.length());
    }
}

class Node {
    private char key;
    private Map<Character, Node> nexts = new HashMap<>();

    public Node(char key) {
        this.key = key;
    }

    public void add(char c) {
        nexts.put(c, nexts.getOrDefault(c, new Node(c)));
    }

    public Node get(char c) {
        return nexts.get(c);
    }

    public int size() {
        return nexts.size();
    }

    public String toString() {
        return "key : " + key + nexts.toString();
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
