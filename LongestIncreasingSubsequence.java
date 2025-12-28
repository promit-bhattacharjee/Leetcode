package LeetCode;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    class Solution {
        // Binary search inside the "sub" list
        private int binarySearch(ArrayList<Integer> sub, int target) {
            int left = 0, right = sub.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (sub.get(mid) == target) {
                    return mid;
                } else if (sub.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left; // insertion point
        }

        public int lengthOfLIS(int[] nums) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int num : nums) {
                int i = binarySearch(sub, num);
                if (i == sub.size()) {
                    sub.add(num); // append if larger
                } else {
                    sub.set(i, num); // replace to keep subsequence minimal
                }
            }
            return sub.size();
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence out = new LongestIncreasingSubsequence();
        LongestIncreasingSubsequence.Solution sn = out.new Solution();
        int nums[] = { 0, 8, 4, 12 };
        System.out.println(sn.lengthOfLIS(nums)); // ✅ Output: 3
    }
}
