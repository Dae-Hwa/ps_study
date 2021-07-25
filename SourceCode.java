import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(int n, int t, int m, int p) {
        if (t == 0) {
            return "";
        }

        String answer = "";

        RadixNumber radixNumber = new RadixNumber(n);

        if (p == 1) {
            answer += radixNumber.current();
        }

        for (int i = 2; i < t * m + p; i++) {
            radixNumber.next();
            if (i % m == p % m) {
                answer += radixNumber.current();
            }
        }

        return answer;
    }
}

class RadixNumber {
    private static final String[] NUMBERS_OVER_TEN = new String[]{"A", "B", "C", "D", "E", "F"};
    private List<Integer> figures = new ArrayList<>();
    private int radix;
    private int count;

    public RadixNumber(int radix) {
        this.radix = radix;
        figures.add(0);
    }

    public void next() {
        count++;
        if (count == figures.size()) {
            add(1);
            count = 0;
        }
    }

    public void add(int num) {
        figures.set(0, figures.get(0) + num);
        rebalance();
    }

    private void rebalance() {
        for (int i = 0; i < figures.size(); i++) {
            int cur = figures.get(i);
            if (radix <= cur) {
                if (i + 1 == figures.size()) {
                    figures.add(0);
                }

                figures.set(i + 1, figures.get(i + 1) + cur / radix);
                figures.set(i, cur % radix);
            }
        }
    }

    public String current() {
        int currentIndex = figures.size() - count - 1;
        int current = figures.get(currentIndex);
        return current < 10 ? String.valueOf(current) : NUMBERS_OVER_TEN[current % 10];
    }

    @Override
    public String toString() {
        return figures.stream()
                       .map(number -> number < 10 ?
                                              String.valueOf(number) :
                                              NUMBERS_OVER_TEN[number % 10]
                       ).collect(Collectors.joining());
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        2,
                        4,
                        2,
                        1
                },
                new Object[]{
                        16,
                        16,
                        2,
                        1
                },
                new Object[]{
                        16,
                        16,
                        2,
                        2
                },
                new Object[]{
                        16,
                        0,
                        2,
                        2
                },
                new Object[]{
                        16,
                        0,
                        2,
                        1
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String result = new Solution().solution((int) arguments[0], (int) arguments[1], (int) arguments[2], (int) arguments[3]);

            System.out.println(result);
        }
    }
}
