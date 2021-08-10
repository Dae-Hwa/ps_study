import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int m, int n, String[] board) {

        // 블록을 90도 돌려서 삽입
        List<List<Block>> blocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            blocks.add(new ArrayList<>());
        }
        for (String row : board) {
            for (int i = 0; i < row.length(); i++) {
                blocks.get(i).add(0, new Block(row.charAt(i)));
            }
        }

        boolean isEnded = false;
        int point = 0;

        while (!isEnded) {
            isEnded = true;
            for (int i = 0; i < blocks.size() - 1; i++) {
                for (int j = 0; j < blocks.get(i).size() - 1; j++) {
                    if (blocks.get(i + 1).size() <= j + 1) continue;

                    Block curBlock = blocks.get(i).get(j);
                    Block bottomBlock = blocks.get(i + 1).get(j);
                    Block rightBlock = blocks.get(i).get(j + 1);
                    Block bottomRightBlock = blocks.get(i + 1).get(j + 1);

                    if (curBlock.hasTheSameNameWith(bottomBlock) &&
                        curBlock.hasTheSameNameWith(rightBlock) &&
                        curBlock.hasTheSameNameWith(bottomRightBlock)
                    ) {
                        curBlock.delete();
                        bottomBlock.delete();
                        rightBlock.delete();
                        bottomRightBlock.delete();
                        isEnded = false;
                    }
                }
            }

            for (int i = 0; i < blocks.size(); i++) {
                List<Block> columns = blocks.get(i);
                for (int j = 0; j < columns.size(); j++) {
                    Block curBlock = columns.get(j);
                    if (curBlock.willBeDeleted()) {
                        columns.remove(j);
                        point++;
                        j--;
                    }
                }
            }
        }

        int answer = point;
        return answer;
    }

    static class Block {
        private char name;
        private boolean willBeDeleted;

        public Block(char name) {
            this.name = name;
        }

        public boolean hasTheSameNameWith(Block block) {
            return name == block.name;
        }

        public void delete() {
            willBeDeleted = true;
        }

        public boolean willBeDeleted() {
            return willBeDeleted;
        }

        @Override
        public String toString() {
            return Character.toString(name);
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        4,
                        5,
                        new String[]{
                                "CCBDE",
                                "AAADE",
                                "AAABF",
                                "CCBBF"
                        }
                },
                new Object[]{
                        6,
                        6,
                        new String[]{
                                "TTTANT",
                                "RRFACC",
                                "RRRFCC",
                                "TRRRAA",
                                "TTMMMF",
                                "TMMTTJ"
                        }
                },
                new Object[]{
                        2,
                        2,
                        new String[]{
                                "AA",
                                "AA"
                        }

                },
                new Object[]{
                        2,
                        2,
                        new String[]{
                                "AA",
                                "AB"
                        }

                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int) arguments[0], (int) arguments[1], (String[]) arguments[2]));
        }
    }
}
