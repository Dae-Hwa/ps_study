import java.math.BigInteger;

class Solution {
    public int solution(int n) {
        BigInteger prev = BigInteger.ZERO;
        BigInteger cur = BigInteger.ONE;

        for (int i = 0; i < n - 1; i++) {
            BigInteger next = prev.add(cur);
            prev = cur;
            cur = next;
        }

        return cur.mod(BigInteger.valueOf(1234567)).intValue();
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{3},
                new Object[]{5},
                new Object[]{1},
                new Object[]{6},
                new Object[]{7},
                new Object[]{10000}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int result = new Solution().solution((Integer) arguments[0]);

            System.out.println(result);
        }
    }
}
