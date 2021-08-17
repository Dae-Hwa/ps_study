import java.util.*;

class Solution {
    public int solution(String[][] relation) {

        int rowLength = relation.length;
        int columnLength = relation[0].length;

        List<Set<Integer>> keyCombinations = new ArrayList<>();

        // index 실수
        for (int i = 1; i <= columnLength; i++) {
            List<Set<Integer>> combinations = combinations(columnLength, i);

            for (Set<Integer> combination : combinations) {
                if (!isMinimum(combination, keyCombinations)) {
                    continue;
                }

                if (isUnique(rowLength, combination, relation)) {
                    keyCombinations.add(combination);
                }
            }
        }

        return keyCombinations.size();
    }

    private boolean isMinimum(Set<Integer> combination, List<Set<Integer>> keyCombinations) {
        for (Set<Integer> keyCombination : keyCombinations) {
            if (combination.containsAll(keyCombination)) return false;
        }

        return true;
    }

    private boolean isUnique(int rowLength, Set<Integer> combination, String[][] relation) {
        Set<String> tuples = new HashSet<>();

        for (int i = 0; i < rowLength; i++) {
            StringBuilder current = new StringBuilder();
            for (int each : combination) {
                current.append(relation[i][each]);
            }

            if (!tuples.add(current.toString())) {
                return false;
            }
        }

        return true;
    }

    private List<Set<Integer>> combinations(int n, int r) {
        List<Set<Integer>> combinations = new ArrayList<>();
        calculateCombinations(n, r, combinations, new ArrayDeque<>());
        return combinations;
    }

    private void calculateCombinations(int n, int r, List<Set<Integer>> combinations, Deque<Integer> stack) {
        if (stack.size() == r) {
            Set<Integer> combination = new HashSet<>(stack);
            combinations.add(combination);
        }

        for (int i = stack.isEmpty() ? 0 : stack.peek() + 1; i < n; i++) {
            stack.push(i);
            calculateCombinations(n, r, combinations, stack);
            stack.pop();
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{new String[][]{
                        {"100", "ryan", "music", "2"},
                        {"200", "apeach", "math", "2"},
                        {"300", "tube", "computer", "3"},
                        {"400", "con", "computer", "4"},
                        {"500", "muzi", "music", "3"},
                        {"600", "apeach", "music", "2"}
                }},
                new Object[]{new String[][]{
                        {"100", "ryan", "music", "2"}
                }},
                new Object[]{new String[][]{
                        {"100", "ryan", "music", "2"},
                        {"200", "apeach", "math", "2"}
                }},
                new Object[]{new String[][]{
                        {"100", "ryan", "music", "2", "3"},
                        {"200", "apeach", "math", "2", "3"}
                }},
                new Object[]{new String[][]{
                        {"a", "1", "aaa", "c", "ng"},
                        {"b", "1", "bbb", "c", "g"},
                        {"c", "1", "aaa", "d", "ng"},
                        {"d", "2", "bbb", "d", "ng"}
                }},
                new Object[]{new String[][]{
                        {"a", "1", "a"},
                        {"a", "2", "a"},
                        {"b", "2", "b"},
                        {"c", "4", "c"}
                }}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((String[][]) arguments[0]));
        }
    }
}
