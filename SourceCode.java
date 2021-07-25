class Solution {
    public String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();

        //2단계
        StringBuilder sb = new StringBuilder();

        for (char each : new_id.toCharArray()) {
            if (isAlphabet(each) || isNumber(each) || isAllowedSpecialCharacter(each)) {
                sb.append(each);
            }
        }
        new_id = sb.toString();

        // 3단계
        new_id = new_id.replaceAll("\\.{2,}", ".");

        // 4단계
        new_id = new_id.replaceAll("^\\.+|\\.+$", "");

        // 5단계
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6단계
        if (15 < new_id.length()) {
            new_id = new_id.substring(0, 15);
        }
        new_id = new_id.replaceAll("\\.+$", "");

        // 7단계
        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }

    private boolean isAlphabet(char c) {
        return 'a' <= c && c <= 'z';
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    private boolean isAllowedSpecialCharacter(char c) {
        return c == '-' || c == '_' || c == '.';
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{"...!@BaT#*..y.abcdefghijklm"},
                new Object[]{"z-+.^."},
                new Object[]{"=.="},
                new Object[]{"123_.def"},
                new Object[]{"abcdefghijklmn.p"}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String result = new Solution().solution((String) arguments[0]);

            System.out.println(result);
        }
    }
}
