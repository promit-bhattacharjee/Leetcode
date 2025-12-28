package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HouseRobberII {
    class Solution {
        // void DFS(int curr, int[] nums[]){

        // }
        int[] helper(int dp[]) {
            for (int i = 2; i < dp.length; i++) {
                int max = 0;
                for (int j = i - 2; j >= 0; j--) {
                    max = Math.max(max, dp[j]);
                } 
                dp[i] = max + dp[i];
            }
            return dp;
        }

        public int rob(int[] nums) {
            int l = nums.length;
            int dp[] = nums;
            if (l < 1)
                return 0;
            if (l == 1)
                return nums[0];

            dp = helper(Arrays.copyOfRange(nums, 0, l-1));
            int arr[]=Arrays.copyOfRange(nums, 0,l);
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            int max = 0;
            for (int i = 0; i < dp.length; i++) {
                max = Math.max(max, dp[i]);
            }
            int max2 = 0;
            dp = helper(Arrays.copyOfRange(nums, 1, l));
            for (int i = 0; i < dp.length; i++) {
                max2 = Math.max(max2, dp[i]);
            }
            return Math.max(max, max2);
        }
    }

    public static void main(String[] args) {
        HouseRobberII out = new HouseRobberII();
        HouseRobberII.Solution sol = out.new Solution();
        int nums[] = { 2, 1, 1, 2 };
        int result = sol.rob(nums);
        System.out.println("ANS");
        System.out.println(result);
    }
}
