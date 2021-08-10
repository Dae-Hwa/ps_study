class Solution {
    public String solution(int[][] scores) {

        int numberOfStudents = scores.length;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < numberOfStudents; i++) {
            int sum = 0;
            int max = -1;
            int maxCount = 0;
            int min = 101;
            int minCount = 0;
            int average = 0;
            for (int j = 0; j < numberOfStudents; j++) {
                int cur = scores[j][i];
                if (max < cur) {
                    max = cur;
                    maxCount = 0;
                } else if (max == cur) {
                    maxCount++;
                }
                if (cur < min) {
                    min = cur;
                    minCount = 0;
                } else if (min == cur) {
                    minCount++;
                }
                sum += cur;
            }
            int selfEstimationScore = scores[i][i];

            if ((selfEstimationScore == max && maxCount == 0) ||
                (selfEstimationScore == min && minCount == 0)) {
                sum -= selfEstimationScore;
                average = sum / (numberOfStudents - 1);
            } else {
                average = sum / numberOfStudents;
            }

            switch (average / 10) {
                case 9: {
                    answer.append("A");
                    break;
                }
                case 8: {
                    answer.append("B");
                    break;
                }
                case 7: {
                    answer.append("C");
                    break;
                }
                case 6:
                case 5: {
                    answer.append("D");
                    break;
                }
                default: {
                    answer.append("F");
                }
            }
        }

        return answer.toString();
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[][]{
                                {100, 90, 98, 88, 65},
                                {50, 45, 99, 85, 77},
                                {47, 88, 95, 80, 67},
                                {61, 57, 100, 80, 65},
                                {24, 90, 94, 75, 65}
                        }
                },
                new Object[]{
                        new int[][]{
                                {50, 90},
                                {50, 87}
                        }
                },
                new Object[]{
                        new int[][]{
                                {70, 49, 90},
                                {68, 50, 38},
                                {73, 31, 100}
                        }
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int[][]) arguments[0]));
        }
    }
}
