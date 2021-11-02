import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {

        List<List<Integer>> split = Arrays.stream(s.split("},\\{"))
                                          .map(str -> str.replaceAll("}", "")
                                                         .replaceAll("\\{", "")
                                          ).sorted(Comparator.comparing(o -> o.length()))
                                          .map(str -> Arrays.stream(str.split(","))
                                                            .map(Integer::valueOf)
                                                            .collect(Collectors.toList())
                                          ).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < split.size(); i++) {
            List<Integer> cur = split.get(i);
            cur.removeAll(result);
            result.addAll(cur);
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
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
