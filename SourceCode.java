class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            var number = numbers[i];
            var candidate = number;

            if (Long.bitCount((number + 1) ^ number) <= 2) {
                answer[i] = number + 1;
            } else {
                long temp = (number + 1) | (number >> 1);
                if (Long.bitCount(temp ^ number) <= 2) {
                    answer[i] = temp;
                }
            }

            while (answer[i] == 0) {
                candidate++;

                if (Long.bitCount(candidate ^ number) <= 2) {
                    answer[i] = candidate;
                    break;
                }
            }
        }

        return answer;
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
