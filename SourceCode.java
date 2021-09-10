import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> cards = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long cardNumber = Long.parseLong(br.readLine());
            int cardCount = cards.getOrDefault(cardNumber, 0);

            cards.put(cardNumber, cardCount + 1);
        }

        long answer = cards.keySet().stream()
                           .sorted(Comparator.naturalOrder())
                           .sorted(Comparator.comparing(cardNumber -> cards.get(cardNumber)).reversed())
                           .findFirst().get();

        System.out.println(answer);
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println();
        }
    }
}
