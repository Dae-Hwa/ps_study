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
                if (room[y].charAt(x) == CANDIDATE && !checkPlace(room, x, y)) {
                    return 0;
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

        if (leftOne < 0) {
            return true;
        }

        char left = room[y].charAt(leftOne);
        if (left == CANDIDATE) {
            return false;
        }

        if (leftTwo < 0) {
            return true;
        }

        return !(left == EMPTY_TABLE && room[y].charAt(leftTwo) == CANDIDATE);
    }

    private boolean checkBottom(String[] room, int x, int y) {
        int bottomOne = y + 1;
        int bottomTwo = y + 2;

        if (ROOM_SIZE <= bottomOne) {
            return true;
        }

        char bottom = room[bottomOne].charAt(x);
        if (bottom == CANDIDATE) {
            return false;
        }

        if (ROOM_SIZE <= bottomTwo) {
            return true;
        }

        return !(bottom == EMPTY_TABLE && room[bottomTwo].charAt(x) == CANDIDATE);
    }

    private boolean checkRight(String[] room, int x, int y) {
        int rightOne = x + 1;
        int rightTwo = x + 2;

        if (ROOM_SIZE <= rightOne) {
            return true;
        }

        char right = room[y].charAt(rightOne);
        if (right == CANDIDATE) {
            return false;
        }

        if (ROOM_SIZE <= rightTwo) {
            return true;
        }

        return !(right == EMPTY_TABLE && room[y].charAt(rightTwo) == CANDIDATE);
    }

    private boolean checkBottomLeft(String[] room, int x, int y) {
        int bottomOne = y + 1;
        int leftOne = x - 1;

        if (!(0 <= leftOne && bottomOne < ROOM_SIZE)) {
            return true;
        }

        char bottomLeft = room[bottomOne].charAt(leftOne);
        char left = room[y].charAt(leftOne);
        char bottom = room[bottomOne].charAt(x);

        return (left == PARTITION && bottom == PARTITION) || bottomLeft != CANDIDATE;
    }


    private boolean checkBottomRight(String[] room, int x, int y) {
        int bottomOne = y + 1;
        int rightOne = x + 1;

        if (!(rightOne < ROOM_SIZE && bottomOne < ROOM_SIZE)) {
            return true;
        }

        char bottomRight = room[bottomOne].charAt(rightOne);
        char right = room[y].charAt(rightOne);
        char bottom = room[bottomOne].charAt(x);

        return (right == PARTITION && bottom == PARTITION) || bottomRight != CANDIDATE;
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
