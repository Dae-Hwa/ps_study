import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n + 2];
        Arrays.fill(students, 1);
        students[0] = 0;
        students[n + 1] = 0;

        for (int each : reserve) {
            students[each] = 2;
        }

        for (int each : lost) {
            students[each] -= 1;
        }

        for (int each : lost) {
            if (1 <= students[each]) {
                continue;
            }

            if (students[each - 1] == 2) {
                students[each - 1]--;
                students[each]++;
            } else if (students[each + 1] == 2) {
                students[each + 1]--;
                students[each]++;
            }
        }

        return (int) Arrays.stream(students).filter(value -> 1 <= value).count();
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        5,
                        new int[]{2, 4},
                        new int[]{1, 3, 5}
                },
                new Object[]{
                        5,
                        new int[]{2, 4},
                        new int[]{3}
                },
                new Object[]{
                        3,
                        new int[]{3},
                        new int[]{1}
                },
                new Object[]{
                        5,
                        new int[]{1, 3, 5},
                        new int[]{2, 4}
                },
                new Object[]{
                        1,
                        new int[]{1},
                        new int[]{1}
                },
                new Object[]{
                        2,
                        new int[]{2},
                        new int[]{2}
                },
                new Object[]{
                        2,
                        new int[]{1},
                        new int[]{1}
                },
                new Object[]{
                        5,
                        new int[]{2, 3, 4},
                        new int[]{3, 4, 5}
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int result = new Solution().solution((int) arguments[0], (int[]) arguments[1], (int[]) arguments[2]);

            System.out.println(result);
        }
    }
}
