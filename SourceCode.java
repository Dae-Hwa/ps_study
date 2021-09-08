import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int N = lock.length;
        int lockLeft = N;
        int lockRight = 0;
        int lockTop = N;
        int lockBottom = 0;

        List<int[]> blanks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cur = lock[i][j];

                if (cur == 0) {
                    if (j < lockLeft) lockLeft = j;
                    if (lockRight < j) lockRight = j;
                    if (i < lockTop) lockTop = i;
                    if (lockBottom < i) lockBottom = i;

                    blanks.add(new int[]{i, j});
                }
            }
        }

        int[][] expectedKey = new int[lockBottom - lockTop + 1][lockRight - lockLeft + 1];

        for (int[] blank : blanks) {
            expectedKey[blank[0] - lockTop][blank[1] - lockLeft] = 1;
        }

        int M = key.length;

        for (int i = 0; i < M; i++) {
            if (M <= i + lockBottom - lockTop) continue;

            for (int j = 0; j < M; j++) {
                if (M <= j + lockRight - lockLeft) continue;

                if (
                        checkTop(expectedKey, key, i, j) ||
                        checkLeft(expectedKey, key, i, j) ||
                        checkBottom(expectedKey, key, i, j) ||
                        checkRight(expectedKey, key, i, j)
                ) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean checkTop(int[][] expectedKey, int[][] key, int keyTop, int keyLeft) {

        for (int i = 0; i < expectedKey.length; i++) {
            int[] row = expectedKey[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] != key[i + keyTop][j + keyLeft]) return false;
            }
        }

        return true;
    }

    public boolean checkLeft(int[][] expectedKey, int[][] key, int keyTop, int keyBottom) {

        for (int i = 0; i < expectedKey.length; i++) {
            int reverseI = expectedKey.length - i - 1;
            int[] row = expectedKey[reverseI];
            for (int j = 0; j < row.length; j++) {

                if (row[j] != key[i + keyTop][j + keyBottom]) return false;
            }
        }

        return true;
    }

    public boolean checkRight(int[][] expectedKey, int[][] key, int keyTop, int keyBottom) {

        for (int i = 0; i < expectedKey.length; i++) {
            int[] row = expectedKey[i];
            for (int j = 0; j < row.length; j++) {
                int reverseJ = row.length - j - 1;

                if (row[reverseJ] != key[i + keyTop][j + keyBottom]) return false;
            }
        }

        return true;
    }

    public boolean checkBottom(int[][] expectedKey, int[][] key, int keyTop, int keyBottom) {

        for (int i = 0; i < expectedKey.length; i++) {
            int reverseI = expectedKey.length - i - 1;
            int[] row = expectedKey[reverseI];
            for (int j = 0; j < row.length; j++) {
                int reverseJ = row.length - j - 1;

                if (row[reverseJ] != key[i + keyTop][j + keyBottom]) return false;
            }
        }

        return true;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
//                new Object[]{
//                        new int[][]{
//                                {0, 0, 0},
//                                {1, 0, 0},
//                                {0, 1, 1}
//                        },
//                        new int[][]{
//                                {1, 1, 1},
//                                {1, 1, 0},
//                                {1, 0, 1}
//                        }
//                },
                new Object[]{
                        new int[][]{
                                {0, 0, 0},
                                {1, 0, 0},
                                {0, 1, 1}
                        },
                        new int[][]{
                                {1, 1, 0},
                                {1, 1, 0},
                                {1, 1, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {0, 0, 0},
                                {1, 0, 0},
                                {0, 1, 1}
                        },
                        new int[][]{
                                {1, 0, 1},
                                {0, 1, 1},
                                {1, 1, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {0, 0, 0},
                                {1, 0, 0},
                                {0, 1, 1}
                        },
                        new int[][]{
                                {1, 1, 1},
                                {0, 1, 1},
                                {1, 0, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {0, 0, 0},
                                {1, 0, 0},
                                {1, 1, 1}
                        },
                        new int[][]{
                                {1, 0, 1},
                                {1, 0, 0},
                                {1, 0, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {0, 0, 0},
                                {1, 0, 0},
                                {1, 1, 1}
                        },
                        new int[][]{
                                {1, 0, 1},
                                {1, 0, 0},
                                {0, 0, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {1, 0},
                                {1, 1},
                        },
                        new int[][]{
                                {1, 0, 1},
                                {1, 0, 0},
                                {1, 0, 1}
                        }
                },
                new Object[]{
                        new int[][]{
                                {1, 0},
                                {1, 1},
                                },
                        new int[][]{
                                {1, 1, 1},
                                {1, 0, 0},
                                {1, 0, 1}
                        }
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int[][]) arguments[0], (int[][]) arguments[1]));
        }
    }
}
