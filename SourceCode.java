import java.util.Arrays;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        int maxIndex = -1;

        int left = 0;
        int right = k;

        for (int i = k - 1; i < nums.length; i++, left++, right++) {
            if (maxIndex < left) {
                maxIndex = left;
                for (int j = left; j < right; j++) {
                    if (nums[maxIndex] < nums[j]) maxIndex = j;
                }
            }

            if (nums[maxIndex] <= nums[i]) maxIndex = i;

            answer[left] = nums[maxIndex];
        }


        return answer;
    }
}

public class SourceCode {
    public static void main(String[] args) {
        Object[] inputs = new Object[]{
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
//                new Object[]{
//                        new int[]{9, 11},
//                        2
//                },
//                new Object[]{
//                        new int[]{4, -2},
//                        2
//                }
        };

        for (Object input : inputs) {
            Object[] arguments = (Object[]) input;

            int[] result = new Solution().maxSlidingWindow((int[]) arguments[0], (int) arguments[1]);

            System.out.println(Arrays.toString(result));
        }
    }
}
