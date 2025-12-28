package LeetCode;

public class JumpGame {
    class Solution {

        public boolean canJump(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                boolean found = false;
                for (int i = right - 1; i >= left; i--) {
                    if (nums[i] + i >= right) {
                        right = i;
                        found = true;
                        break;
                    }
                }
                if (!found)
                    return false;
            }

            return right == 0;
        }

    }

    public static void main(String[] args) {
        JumpGame out = new JumpGame();
        JumpGame.Solution sn = out.new Solution();
        int nums[] = {
                2, 0
        };
        System.out.println(sn.canJump(nums));
    }
}
