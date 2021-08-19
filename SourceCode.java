import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;

        int[] answer = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }

        /* nums.length - k + 1 회 만큼 돌아야 한다.
         * k ~ nums.length + 1만큼 돌아야 하는데, 이러면 i가 헷갈리므로 k-1 ~ nums.length 만큼 반복
         */
        for (int i = k - 1; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            answer[i - k + 1] = nums[deque.peek()];
        }

        return answer;
    }
}

class Node implements Comparable<Node> {
    private int index;
    private int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean isIndexSmallerThan(int target) {
        return index < target;
    }

    @Override
    public int compareTo(Node o) {
        return Comparator.comparingInt(Node::value)
                         .reversed()
                         .compare(this, o);
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
                new Object[]{
                        new int[]{1, -1},
                        2
                },
                new Object[]{
                        new int[]{1, 3, -1, -3, 5, 3, 6, 7},
                        3
                },
                new Object[]{
                        new int[]{1},
                        1
                },
                new Object[]{
                        new int[]{1, -1},
                        1
                },
                new Object[]{
                        new int[]{1, 3, 1, 2, 0, 5},
                        3
                },
                new Object[]{
                        new int[]{9, 10, 9, -7, -4, -8, 2, -6},
                        5
                },
                new Object[]{
                        new int[]{9, 11},
                        2
                },
                new Object[]{
                        new int[]{4, -2},
                        2
                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().maxSlidingWindow((int[]) arguments[0], (int) arguments[1]);

            System.out.println(Arrays.toString(result));
        }
    }
}
