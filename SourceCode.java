import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(solution(S, T));
    }

    public static int solution(String S, String T) {

        Deque<Character> t = T.chars()
                              .mapToObj(value -> (char) value)
                              .collect(Collectors.toCollection(LinkedList::new));

        while (S.length() < t.size()) {
            if (t.peekLast() == 'B') {
                t.pollLast();
                Collections.reverse((List<Character>) t);
            } else {
                t.pollLast();
            }
        }

        String result = t.stream()
                         .map(character -> Character.toString(character))
                         .collect(Collectors.joining());

        return S.equals(result) ? 1 : 0;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        "B",
                        "ABBA"
                },
                new Object[]{
                        "B",
                        "ABBB"
                },
                new Object[]{
                        "AB",
                        "ABB"
                },
                new Object[]{
                        "BA",
                        "ABB"
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(Main.solution((String) arguments[0], (String) arguments[1]));
        }
    }
}
