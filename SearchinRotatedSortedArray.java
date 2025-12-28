package LeetCode;

public class SearchinRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1, ans = -1;
            while (left <= right) {
                int center = left + (right - left) / 2;
                if (target == nums[center]) {
                    return center;
                }
                if (nums[center] <= nums[right]) {
                    if (target > nums[center] && target <= nums[right]) {
                        left = center + 1;
                    }else{
                        right=center-1;
                    }
                    
                }else{
                    if (target<nums[center]&& target>=nums[left]) {
                        right=center-1;
                    }else{
                        left=center+1;
                    }
                }
            }
            return -1;
        }
    }

    // PSVM to test
    public static void main(String[] args) {
        SearchinRotatedSortedArray outer = new SearchinRotatedSortedArray();
        SearchinRotatedSortedArray.Solution sol = outer.new Solution();

        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Target 0: " + sol.search(nums1, 0)); // expected 4
        System.out.println("Target 3: " + sol.search(nums1, 3)); // expected -1
        System.out.println("Target 7: " + sol.search(nums1, 7)); // expected 3

        int[] nums2 = { 1 };
        System.out.println("Target 0: " + sol.search(nums2, 0)); // expected -1
        System.out.println("Target 1: " + sol.search(nums2, 1)); // expected 0
    }
}
