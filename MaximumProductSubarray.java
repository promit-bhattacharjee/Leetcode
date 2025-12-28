package LeetCode;

public class MaximumProductSubarray {
    class Solution {
        public int maxProduct(int[] nums) {
            int length = nums.length;
            int max = nums[0];
            int min = nums[0];
            int ans = nums[0];
            for (int i = 1; i < length; i++) {
                int temp=max;
                max = Math.max(nums[i], Math.max(min * nums[i], temp * nums[i]));
                min = Math.min(nums[i], Math.min(min * nums[i], temp * nums[i]));
                ans = Math.max(ans, max);
            }
            return ans;

        }

    }

    public static void main(String[] args) {
        MaximumProductSubarray out = new MaximumProductSubarray();
        MaximumProductSubarray.Solution sn = out.new Solution();

        int[][] testCases = {
                { -2, 3, -4 }, // expected 24 (subarray [-2,3,-4])
                { 2, 3, -2, 4 }, // expected 6 (subarray [2,3])
                { -2, 0, -1 }, // expected 0 (subarray [0])
                { -1, -3, -10, 0, 60 }, // expected 60 (subarray [60])
                { -2, -3, 0, -2, -40 }, // expected 80 (subarray [-2,-40])
                { 0, 2 }, // expected 2
                { -2 }, // expected -2
                { 3, -1, 4 }, // expected 4
                { -1, -2, -9, -6 }, // expected 108 (whole array)
                { 1, 2, 3, 4 }, // expected 24 (whole array)
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + sn.maxProduct(testCases[i]));
        }
    }
}
