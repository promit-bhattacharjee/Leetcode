package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
    class Solution {

        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            HashMap<Character, Integer> have = new HashMap<>();
            int haveSize = 0;
            for (char i : t.toCharArray()) {
                if (have.containsKey(i)) {
                    have.put(i, have.get(i) + 1);
                } else {
                    have.put(i, 1);
                }
                haveSize++;
            }
            String result = s;
            int left = 0;
            int right = left;
            HashMap<Character, Integer> need = new HashMap<>();
            while (left < s.length()) {
                int needSize = 0;
                while (needSize < haveSize && right < s.length()) {
                    if (have.containsKey(s.charAt(right))) {
                        if (need.containsKey(s.charAt(right))) {
                            need.put(s.charAt(right), need.get(s.charAt(right)) + 1);

                        } else {
                            need.put(s.charAt(right), 1);
                        }
                    }
                    right++;
                }
                if (haveSize == needSize && result.length() > s.substring(left, right).length()) {
                    result = s.substring(left, right);
                }
                // need.replace(s.charAt(left))
                left++;
            }
            return result;
        }

    }
}