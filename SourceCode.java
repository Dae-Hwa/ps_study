class Solution {
    public String solution(String number, int k) {

        char[] numbers = new char[number.length() - k];

        int startPoint = 0;
        for (int i = 0; i < numbers.length; i++) {
            int maxNumberIndex = startPoint;
            for (int j = startPoint; j < number.length() && j <= number.length() - numbers.length  + i; j++) {
                if (number.charAt(maxNumberIndex) < number.charAt(j)) {
                    maxNumberIndex = j;
                }
            }
            numbers[i] = number.charAt(maxNumberIndex);

            startPoint = maxNumberIndex + 1;
        }

        return String.valueOf(numbers);
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{"1924", 2},
                new Object[]{"1231234", 3},
                new Object[]{"4177252841", 4}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String result = new Solution().solution((String) arguments[0], (int) arguments[1]);

            System.out.println(result);
        }
    }
}
