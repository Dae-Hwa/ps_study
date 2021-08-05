import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] orders, int[] course) {

        List<String> result = new ArrayList<>();

        for (int each : course) {
            Map<List<Character>, Integer> menu = new HashMap<>();
            for (String order : orders) {
                List<List<Integer>> combinations = combinations(order.length(), each);

                for (List<Integer> combination : combinations) {
                    List<Character> current = new ArrayList<>();

                    for (int index : combination) {
                        current.add(order.charAt(index));
                    }

                    Collections.sort(current);

                    menu.put(current, menu.getOrDefault(current, 0) + 1);
                }

            }

            if (menu.size() < 2) {
                continue;
            }

            List<Map.Entry<List<Character>, Integer>> sortedMenu = menu.entrySet().stream()
                    .sorted((o1, o2) -> Comparator.comparing((Map.Entry e) -> (int) e.getValue()).reversed().compare(o1, o2))
                    .collect(Collectors.toList());

            if (sortedMenu.get(0).getValue() < 2) {
                continue;
            }

            result.add(sortedMenu.get(0).getKey().parallelStream().map(String::valueOf).collect(Collectors.joining()));

            int prev = sortedMenu.get(0).getValue();
            for (int i = 1; i < sortedMenu.size(); i++) {
                int cur = sortedMenu.get(i).getValue();

                if (cur == prev) {
                    result.add(sortedMenu.get(i).getKey().parallelStream().map(String::valueOf).collect(Collectors.joining()));
                } else {
                    break;
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[]{});
    }

    private List<List<Integer>> combinations(int n, int r) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationsInner(combinations, new ArrayDeque<>(), n, r);
        return combinations;
    }

    private void combinationsInner(List<List<Integer>> result, Deque<Integer> stack, int n, int r) {
        if (stack.size() == r) {
            result.add(new ArrayList<>(stack));
        }

        for (int i = stack.isEmpty() ? 0 : stack.peek() + 1; i < n; i++) {
            stack.push(i);
            combinationsInner(result, stack, n, r);
            stack.pop();
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                        new int[]{2, 3, 4}
                },
                new Object[]{
                        new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                        new int[]{2, 3, 5}
                },
                new Object[]{
                        new String[]{"XYZ", "XWY", "WXA"},
                        new int[]{2, 3, 4}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            String[] result = new Solution().solution((String[]) arguments[0], (int[]) arguments[1]);

            System.out.println(Arrays.toString(result));
        }
    }
}
