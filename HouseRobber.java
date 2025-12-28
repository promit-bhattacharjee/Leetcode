package LeetCode;

import java.util.Arrays;

public class HouseRobber {
    class Solution {
        public int rob(int[] nums) {
            int dp[] = nums;
            if (nums.length == 1) {
                return nums[0];
            } else if (nums.length > 2) {
                dp[0] = nums[0];
                dp[1] = nums[1];
                dp[2] = nums[2] + nums[0];
                for (int i = 3; i < dp.length; i++) {
                    int j = i - 2;
                    int max=0;
                    while (j >= 0) {
                        max = Math.max(nums[j], max);
                        j--;
                    }
                    dp[i]=max+dp[i];
                }
            }
            // System.out.println(Arrays.toString(nums));
            return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
        }

    }

    public static void main(String[] args) {
        HouseRobber out = new HouseRobber();
        HouseRobber.Solution sn = out.new Solution();
        int n[] = {
                100, 1, 1, 100
        };
        System.out.println(sn.rob(n));
    }
}
