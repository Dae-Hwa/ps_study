import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Print> prints = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            prints.offerLast(new Print(i, priority));
        }

        int cnt = 0;


        while (!prints.isEmpty()) {
            Print current = prints.pollFirst();

            if (isPrimary(current.priority, priorities)) {
                priorities[current.index] = -1;
                cnt++;
                if (current.index == location) return cnt;
                continue;
            }

            prints.offerLast(current);
        }

        return cnt;
    }

    private boolean isPrimary(int priority, int[] priorities) {
        for (int each : priorities) {
            if (priority < each) return false;
        }

        return true;
    }

    static class Print {
        private int index;
        private int priority;

        public Print(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{new int[]{2, 1, 3, 2}, 2},
                new Object[]{new int[]{1, 1, 9, 1, 1, 1}, 0}
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            System.out.println(new Solution().solution((int[]) arguments[0], (int) arguments[1]));
        }
    }
}
