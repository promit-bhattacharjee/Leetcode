package LeetCode;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() ==0 || s==null) {
                return 0;
            }
            int right = 0;
            int left = 0;
            int maxLen = 0;
            HashSet<Character> hs = new HashSet<>();
            while (right < s.length()) {
                char cur = s.charAt(right);
                while (hs.contains(cur)) {
                    hs.remove(s.charAt(left));
                    left++;
                }
                hs.add(cur);
                right++;
                maxLen = Math.max(maxLen, right-left);
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();
        LongestSubstringWithoutRepeatingCharacters.Solution sol = o.new Solution();

        String s1 = "abcabcbb"; // Expected 3 ("abc")
        String s2 = "bbbbb"; // Expected 1 ("b")
        String s3 = "pwwkew"; // Expected 3 ("wke")
        String s4 = ""; // Expected 0
        String s5 = "abcdef"; // Expected 6 ("abcdef")

        System.out.println("Input: " + s1 + " → " + sol.lengthOfLongestSubstring(s1));
        System.out.println("Input: " + s2 + " → " +
        sol.lengthOfLongestSubstring(s2));
        System.out.println("Input: " + s3 + " → " +
        sol.lengthOfLongestSubstring(s3));
        System.out.println("Input: " + s4 + " → " +
        sol.lengthOfLongestSubstring(s4));
        System.out.println("Input: " + s5 + " → " +
        sol.lengthOfLongestSubstring(s5));
    }
}
