import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {

        Stage[] stageDetails = new Stage[N];

        for (int i = 0; i < N; i++) {
            stageDetails[i] = new Stage(N - i);
        }

        Map<Integer, Integer> stageCounts = new HashMap<>();

        for (int stage : stages) {
            int cnt = stageCounts.getOrDefault(stage, 0);
            stageCounts.put(stage, cnt + 1);
        }

        Stage nextStage = new Stage(N + 1);
        nextStage.reachedPeople = stageCounts.getOrDefault(N + 1, 0);

        for (int i = 0; i < N; i++) {
            nextStage = i != 0 ? stageDetails[i - 1] : nextStage;
            Stage stage = stageDetails[i];

            int reachedCount = stageCounts.getOrDefault(stage.num, 0);

            stage.clearedPeople = nextStage.reachedPeople;
            stage.reachedPeople = stage.clearedPeople + reachedCount;
        }

        int[] answer = Arrays.stream(stageDetails)
                               .sorted((o1, o2) -> {
                                   int result = Comparator.<Double>reverseOrder()
                                                        .compare(o1.failureRate(), o2.failureRate());

                                   if (result == 0) {
                                       return Comparator.<Integer>naturalOrder()
                                                      .compare(o1.num, o2.num);
                                   }

                                   return result;
                               }).mapToInt(value -> value.num)
                               .toArray();

        return answer;
    }

    static class Stage {
        int num;
        int reachedPeople;
        int clearedPeople;

        public Stage(int num) {
            this.num = num;
        }

        public int notClearedPeople() {
            return reachedPeople - clearedPeople;
        }

        public double failureRate() {
            if (reachedPeople == 0 || notClearedPeople() == 0) {
                return 0;
            }

            return (double) notClearedPeople() / reachedPeople;
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        5,
                        new int[]{2, 1, 2, 6, 2, 4, 3, 3}
                },
                new Object[]{
                        4,
                        new int[]{4, 4, 4, 4, 4}
                },
                new Object[]{
                        5,
                        new int[]{1, 1, 1, 1, 1}
                },
                new Object[]{
                        5,
                        new int[]{1, 1, 2, 3, 4}
                },
                new Object[]{
                        1,
                        new int[]{2}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().solution((int) arguments[0], (int[]) arguments[1]);

            System.out.println(Arrays.toString(result));
        }
    }
}
