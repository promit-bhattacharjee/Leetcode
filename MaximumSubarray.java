package LeetCode;

public class MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int currentSum=nums[0];
            int maxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                currentSum = Math.max(nums[i],currentSum+nums[i]);
                maxSum = Math.max(currentSum, maxSum);
            }
            return maxSum;
        }
    }

    public static void main(String[] args) {
        MaximumSubarray out = new MaximumSubarray();
        MaximumSubarray.Solution sn = out.new Solution();
        int nums[] = {

               5,4,-1,7,8
        };
        System.out.println(sn.maxSubArray(nums));
    }
}
