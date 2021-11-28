import java.util.*;

class Solution {
    public int solution(String name) {
        int counter = -1;
        for (char c : name.toCharArray()) {
            counter++;
            counter += Math.min(c - 'A', 'Z' - c + 1);
        }

        boolean flag = true;
        int toLeft = 0;
        for (int i = 1; i < name.length(); i++) {
            if (flag && name.charAt(i) != 'A') {
                toLeft--;
                continue;
            }
            if (name.charAt(i) == 'A') {
                flag = false;
                toLeft++;
            } else {
                break;
            }
        }
        flag = false;

        int toRight = 0;
        for (int i = name.length() - 1; 0 <= i; i--) {
            if (flag && name.charAt(i) != 'A') {
                toRight--;
                continue;
            }
            if (name.charAt(i) == 'A') {
                toRight++;
            } else {
                break;
            }
        }

        return counter - Math.max(toLeft, toRight);
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
