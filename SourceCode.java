import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final int OFFSET = 65536;

    public int solution(String str1, String str2) {
        int answer = 0;

        Map<String, Integer> map1 = mappedString(str1);
        Map<String, Integer> map2 = mappedString(str2);

        Map<String, Integer> intersection = intersection(map1, map2);
        Map<String, Integer> union = union(map1, map2);

        double intersectionSize = intersection.values().stream()
                                              .mapToInt(Integer::valueOf)
                                              .sum();

        double unionSize = union.values().stream()
                                .mapToInt(Integer::valueOf)
                                .sum();

        if (intersectionSize == 0 && unionSize == 0) {
            return OFFSET;
        }

        return (int) (intersectionSize / unionSize * OFFSET);
    }

    private Map<String, Integer> intersection(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> intersection = new HashMap<>();

        intersection(intersection, map1, map2);
        intersection(intersection, map2, map1);

        return intersection;
    }

    private void intersection(Map<String, Integer> intersection, Map<String, Integer> a, Map<String, Integer> b) {
        for (String key : a.keySet()) {
            if (b.containsKey(key)) {
                intersection.put(key, Math.min(a.get(key), b.get(key)));
            }
        }
    }

    private Map<String, Integer> union(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> union = new HashMap<>();

        union(union, map1, map2);
        union(union, map2, map1);

        return union;
    }

    private void union(Map<String, Integer> union, Map<String, Integer> a, Map<String, Integer> b) {
        for (String key : a.keySet()) {
            if (b.containsKey(key)) {
                union.put(key, Math.max(a.get(key), b.get(key)));
            } else {
                union.put(key, a.get(key));
            }
        }
    }

    private Map<String, Integer> mappedString(String str) {
        str = formatString(str);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String a = str.substring(i, i + 2);
            if (!(isAlphabet(a))) {
                continue;
            }

            int cnt = map.getOrDefault(a, 0);
            map.put(a, cnt + 1);
        }

        return map;
    }

    private String formatString(String str) {
        return str.toUpperCase();
    }

    private boolean isAlphabet(String str) {
        for (char c : str.toCharArray()) {
            if (!isAlphabet(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphabet(char c) {
        return 'A' <= c && c <= 'Z';
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
