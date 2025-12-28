package LeetCode;
import java.util.Arrays;

public class NonOverlappingIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int count = 0;
            Arrays.sort(intervals,(a,b)->a[1]-b[1]);
            int prevEnd = intervals[0][1];
            for (int row = 1; row < intervals.length; row++) {
                int start = intervals[row][0];
                if (prevEnd>start) {
                    count++;
                }
                else{
                    prevEnd=intervals[row][1];
                }
            }
            return count;
        }
    }
    public static void main(String[] args) {
        NonOverlappingIntervals out = new NonOverlappingIntervals();
        NonOverlappingIntervals.Solution sn = out.new Solution();
          int[][] arr = {
            {1, 2},
            {1, 2},
            {1, 2}
        };
        System.out.println(sn.eraseOverlapIntervals(arr));
    }
}
