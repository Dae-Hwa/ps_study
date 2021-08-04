class Solution {
    private static final char LEFT_BRACE = '(';
    private static final char RIGHT_BRACE = ')';

    public String solution(String p) {
        String answer = parseBrace(p);
        return answer;
    }

    public String parseBrace(String w) {
        int splitPoint = splitPointOf(w);
        if (isCorrectBrace(w)) {
            return w;
        }

        String u = w.substring(0, splitPoint);
        String v = parseBrace(w.substring(splitPoint));

        if (isCorrectBrace(u)) {
            return u + v;
        }

        StringBuilder parsedU = new StringBuilder();

        for (int i = 1; i < u.length() - 1; i++) {
            parsedU.append(u.charAt(i) == LEFT_BRACE ? RIGHT_BRACE : LEFT_BRACE);
        }

        return LEFT_BRACE + v + RIGHT_BRACE + parsedU;
    }

    public boolean isCorrectBrace(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case LEFT_BRACE: {
                    left++;
                    break;
                }
                case RIGHT_BRACE: {
                    right++;
                    break;
                }
            }

            if (left == right && s.charAt(i) != RIGHT_BRACE) {
                return false;
            }
        }

        return true;
    }

    public int splitPointOf(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case LEFT_BRACE: {
                    left++;
                    break;
                }
                case RIGHT_BRACE: {
                    right++;
                    break;
                }
            }

            if (left == right) {
                return i + 1;
            }
        }

        return -1;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{"(()())()"},
                new Object[]{")("},
                new Object[]{"()))((()"}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((String) arguments[0]));
        }
    }
}
