class Solution {
    public String solution(String phone_number) {
        int numberOfExposure = 4;
        int indexOfStartingExposure = phone_number.length() - numberOfExposure;

        return "*".repeat(indexOfStartingExposure) + phone_number.substring(indexOfStartingExposure);
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{"01033334444"},
                new Object[]{"027778888"},
                new Object[]{"4444"}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((String) arguments[0]));
        }
    }
}
