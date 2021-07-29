import java.util.Arrays;

class Solution {
    private static final char CANDIDATE = 'P';
    private static final char EMPTY_TABLE = 'O';
    private static final char PARTITION = 'X';
    private static final int ROOM_SIZE = 5;

    public int[] solution(String[][] places) {
        int[] answer = new int[ROOM_SIZE];

        for (int i = 0; i < ROOM_SIZE; i++) {
            answer[i] = checkPlace(places[i]);
        }

        return answer;
    }

    private int checkPlace(String[] room) {
        for (int y = 0; y < ROOM_SIZE; y++) {
            for (int x = 0; x < ROOM_SIZE; x++) {
                if (room[y].charAt(x) == CANDIDATE) {
                    if (!checkPlace(room, x, y)) {
                        return 0;
                    }
                }
            }
        }

        return 1;
    }

    private boolean checkPlace(String[] room, int x, int y) {
        return checkLeft(room, x, y)
                       && checkBottomLeft(room, x, y)
                       && checkBottom(room, x, y)
                       && checkBottomRight(room, x, y)
                       && checkRight(room, x, y);
    }

    private boolean checkLeft(String[] room, int x, int y) {
        int leftOne = x - 1;
        int leftTwo = x - 2;

        if (0 <= leftOne) {
            char left = room[y].charAt(leftOne);
            if (left == CANDIDATE) {
                return false;
            } else if (left == EMPTY_TABLE && 0 <= leftTwo) {
                if (room[y].charAt(leftTwo) == CANDIDATE) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkBottomLeft(String[] room, int x, int y) {
        int leftOne = x - 1;
        int bottomOne = y + 1;

        if (0 <= leftOne && bottomOne < ROOM_SIZE) {
            char bottomLeft = room[bottomOne].charAt(leftOne);
            char left = room[y].charAt(leftOne);
            char bottom = room[bottomOne].charAt(x);

            if (!(left == PARTITION && bottom == PARTITION) && bottomLeft == CANDIDATE) {
                return false;
            }
        }

        return true;
    }

    private boolean checkBottom(String[] room, int x, int y) {
        int bottomOne = y + 1;
        int bottomTwo = y + 2;

        if (bottomOne < ROOM_SIZE) {
            char bottom = room[bottomOne].charAt(x);
            if (bottom == CANDIDATE) {
                return false;
            } else if (bottom == EMPTY_TABLE && bottomTwo < ROOM_SIZE) {
                if (room[bottomTwo].charAt(x) == CANDIDATE) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkBottomRight(String[] room, int x, int y) {
        int bottomOne = y + 1;
        int rightOne = x + 1;

        if (rightOne < ROOM_SIZE && bottomOne < ROOM_SIZE) {
            char bottomRight = room[bottomOne].charAt(rightOne);
            char right = room[y].charAt(rightOne);
            char bottom = room[bottomOne].charAt(x);

            if (!(right == PARTITION && bottom == PARTITION) && bottomRight == CANDIDATE) {
                return false;
            }
        }

        return true;
    }

    private boolean checkRight(String[] room, int x, int y) {
        int rightOne = x + 1;
        int rightTwo = x + 2;

        if (rightOne < ROOM_SIZE) {
            char right = room[y].charAt(rightOne);
            if (right == CANDIDATE) {
                return false;
            } else if (right == EMPTY_TABLE && rightTwo < ROOM_SIZE) {
                if (room[y].charAt(rightTwo) == CANDIDATE) {
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
                new Object[]{new String[][]{
                        {
                                "POOOP",
                                "OXXOX",
                                "OPXPX",
                                "OOXOX",
                                "POXXP"
                        },
                        {
                                "POOPX",
                                "OXPXP",
                                "PXXXO",
                                "OXXXO",
                                "OOOPP"
                        },
                        {
                                "PXOPX",
                                "OXOXP",
                                "OXPOX",
                                "OXXOP",
                                "PXPOX"
                        },
                        {
                                "OOOXX",
                                "XOOOX",
                                "OOOXX",
                                "OXOOX",
                                "OOOOO"
                        },
                        {
                                "PXPXP",
                                "XPXPX",
                                "PXPXP",
                                "XPXPX",
                                "PXPXP"
                        }
                }}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().solution((String[][]) arguments[0]);

            System.out.println(Arrays.toString(result));
        }
    }
}
