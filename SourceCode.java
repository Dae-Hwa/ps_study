class Solution {
    public boolean solution(int[][] key, int[][] lock) {

        int copyLength = key.length * 2 + lock.length - 2;

        int offset = key.length - 1;
        int n = offset + lock.length;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                for (int rotation = 0; rotation < 4; rotation++) {
                    int[][] copyBoard = new int[copyLength][copyLength];
                    initBoard(copyBoard, lock, offset);

                    fillBoardWithKey(copyBoard, key, r, c, rotation);

                    if (checkBoard(copyBoard, lock.length, offset)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void initBoard(int[][] copyBoard, int[][] lock, int offset) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                copyBoard[i + offset][j + offset] = lock[i][j];
            }
        }
    }

    private void fillBoardWithKey(int[][] copyBoard, int[][] key, int r, int c, int rotation) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                switch (rotation) {
                    case 0: {
                        copyBoard[i + r][j + c] += key[i][j];
                        break;
                    }
                    case 1: {
                        // 90도
                        copyBoard[i + r][j + c] += key[key.length - j - 1][i];
                        break;
                    }
                    case 2: {
                        // 180
                        copyBoard[i + r][j + c] += key[key.length - i - 1][key.length - j - 1];
                        break;
                    }
                    case 3: {
                        // 270
                        copyBoard[i + r][j + c] += key[j][key.length - i - 1];
                        break;
                    }
                }
            }
        }
    }

    private boolean checkBoard(int[][] copyBoard, int lockLength, int offset) {
        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                if (copyBoard[i + offset][j + offset] != 1) {
                    return false;
                }
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
