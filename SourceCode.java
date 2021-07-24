class Solution {
    public boolean solution(int x) {
        int temp = x;
        int sumOfCiphers = 0;

        while (0 < temp) {
            sumOfCiphers += temp % 10;
            temp /= 10;
        }

        return x % sumOfCiphers == 0;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{10},
                new Object[]{12},
                new Object[]{11},
                new Object[]{13}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int) arguments[0]));
        }
    }
}
