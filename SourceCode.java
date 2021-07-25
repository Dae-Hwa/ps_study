import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }

        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[]{1, 4, 2},
                        new int[]{5, 4, 4}
                },
                new Object[]{
                        new int[]{1, 2},
                        new int[]{3, 4}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int result = new Solution().solution((int[]) arguments[0], (int[]) arguments[1]);

            System.out.println(result);
        }
    }
}
