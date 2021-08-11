import java.util.Map;

class Solution {
    public int solution(String s) {

        Map<String, Integer> numberDictionary = Map.of(
                "zero", 0,
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!isNumber(s.charAt(i))) {
                StringBuilder numberKey = new StringBuilder().append(s.charAt(i));
                while (i < s.length() - 1 && !numberDictionary.containsKey(numberKey.toString())) {
                    i++;
                    numberKey.append(s.charAt(i));
                }
                result.append(numberDictionary.get(numberKey.toString()));
            } else {
                result.append(s.charAt(i));
            }
        }

        return Integer.parseInt(result.toString());
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{"one4seveneight"},
                new Object[]{"23four5six7"},
                new Object[]{"2three45sixseven"},
                new Object[]{"123"}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((String) arguments[0]));
        }
    }
}
