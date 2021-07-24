import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();

        return Arrays.stream(arr)
                       .filter(value -> value != min)
                       .toArray();
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[]{4, 3, 2, 1}
                },
                new Object[]{
                        new int[]{10}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().solution((int[]) arguments[0]);

            System.out.println(Arrays.toString(result));
        }
    }
}
