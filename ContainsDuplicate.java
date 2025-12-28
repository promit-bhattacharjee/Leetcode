package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet< Integer> map = new HashSet<>();
            for (int num : nums) {
                if (!map.contains(num)) {
                    map.add(num);
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
