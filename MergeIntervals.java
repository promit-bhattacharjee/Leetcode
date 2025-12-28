package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import partern.Recursion.QuickSort;

import java.util.*;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) return new int[0][];
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            ArrayList<int[]> merged = new ArrayList<>();
            int[] prev = intervals[0];
            merged.add(prev);
            
            for (int i = 1; i < intervals.length; i++) {
                int[] curr = intervals[i];
                if (prev[1] >= curr[0]) { 
                    prev[1] = Math.max(prev[1], curr[1]);
                } else {
                    prev = curr;
                    merged.add(prev);
                }
            }
            
            return merged.toArray(new int[merged.size()][]);
        }
    }

    public static void main(String[] args) {
        MergeIntervals out = new MergeIntervals();
        MergeIntervals.Solution sn = out.new Solution();
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        intervals = sn.merge(intervals);
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
    }
}
