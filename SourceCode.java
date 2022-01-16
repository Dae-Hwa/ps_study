class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            var number = numbers[i];

            if (number % 2 == 0) {
                answer[i] = number + 1;
            } else {
                StringBuilder bit = new StringBuilder()
                        .append("0")
                        .append(Long.toString(number, 2));

                int lastZeroIndex = bit.lastIndexOf("0");
                bit.setCharAt(lastZeroIndex, '1');
                bit.setCharAt(lastZeroIndex + 1, '0');
                answer[i] = Long.parseLong(bit.toString(), 2);
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
