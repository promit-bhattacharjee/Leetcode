package LeetCode;

public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int k = 0;
            int[] ar = new int[nums1.length + nums2.length];
            int i = 0, j = 0;
            // ar[0]=1;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    ar[k++] = nums1[i++];
                } else {
                    ar[k++] = nums2[j++];
                }
            }
            while (i < nums1.length) {
                ar[k++] = nums1[i++];
            }

            // Copy remaining elements from nums2
            while (j < nums2.length) {
                ar[k++] = nums2[j++];
            }
           
            if (k-1%2==0) {
            return (double)ar[k-1/2]+ar[k/2];
            }
            else{
            return (double)k-1/2;
            }
        }

    
    public static void main(String[] args) {
        int[] a = { 1, 3 };
    }}
}
