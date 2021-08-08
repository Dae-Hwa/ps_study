import java.util.*;

class Solution {
    public int[] solution(String msg) {
        return LzwZip.from(msg)
                .zip()
                .result();
    }

    static class LzwZip {
        private Map<String, Integer> dictionary;
        private List<Integer> result;
        private String msg;

        private LzwZip(Map<String, Integer> dictionary, List<Integer> result, String msg) {
            this.dictionary = dictionary;
            this.result = result;
            this.msg = msg;
        }

        public static LzwZip from(String msg) {
            Map<String, Integer> dictionary = new HashMap<>();

            for (int i = 'A'; i <= 'Z'; i++) {
                dictionary.put(Character.toString(i), i - 'A' + 1);
            }

            return new LzwZip(dictionary, new LinkedList<>(), msg);
        }

        public LzwZip zip() {
            for (int i = 0; i < msg.length(); i++) {
                for (int j = msg.length(); i < j; j--) {
                    String candidate = msg.substring(i, j);

                    if (dictionary.containsKey(candidate)) {
                        result.add(dictionary.get(candidate));

                        int endNumberOfKey = j;

                        if (endNumberOfKey < msg.length()) {
                            dictionary.put(candidate + msg.charAt(endNumberOfKey), dictionary.size() + 1);
                        }

                        i += j - i - 1;

                        break;
                    }
                }
            }

            return this;
        }

        public int[] result() {
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{"KAKAO"},
                new Object[]{"TOBEORNOTTOBEORTOBEORNOT"},
                new Object[]{"ABABABABABABABAB"}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().solution((String) arguments[0]);

            System.out.println(Arrays.toString(result));
        }
    }
}
