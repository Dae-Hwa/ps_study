import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;

        for (int i = 0; i < citations.length; i++) {
            int h = i + 1;
            int reverse = citations.length - i - 1;

            if (h <= citations[reverse]) {
                max = Math.max(max, h);
            }
        }

        return max;
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
