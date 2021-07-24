import java.util.Arrays;

class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = n * m / gcd;

        return new int[]{gcd, lcm};
    }

    private int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);

        int mod = x % y;

        if (mod == 0) {
            return y;
        }

        return gcd(y, mod);
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{3, 12},
                new Object[]{2, 5}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().solution((int) arguments[0], (int) arguments[1]);

            System.out.println(Arrays.toString(result));
        }
    }
}
