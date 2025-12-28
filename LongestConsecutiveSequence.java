package LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length<1) {
                return 0;
            }
            HashSet<Integer> hs = new HashSet<>();
            for (int i : nums) {
                hs.add(i);
            }
            int big = 1;
            for (int num : hs) {
                if (!hs.contains(num - 1)) {
                    int count = 1;
                    int last = num;
                    while (hs.contains(last + 1)) {
                        last++;
                        count++;
                    }
                    if (count > big) {
                        big = count;
                    }
                }

            }

            return big;
        }
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence out = new LongestConsecutiveSequence();
        LongestConsecutiveSequence.Solution sn = out.new Solution();
        int[] nums = { 7, 6, 5, 4, 3, 2, 1 };

        System.out.println(sn.longestConsecutive(nums));
    }
}
