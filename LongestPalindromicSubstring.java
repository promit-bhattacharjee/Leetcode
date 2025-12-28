package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

import Stack.reverseAStack;
import partern.Recursion.reverseString;

public class LongestPalindromicSubstring {
    class Solution {

        public String longestPalindrome(String s) {

            if (s.length() == 1)
                return s;
            String result = "";
            for (int center = 0; center < s.length(); center++) {
                int left = center, right = center;
                while (left >= 0 && right < s.length() &&s.charAt(left) == s.charAt(right)) {
                    String str = s.substring(left, right + 1);
                    if (result.length() <= str.length()) {
                        result = str;
                    }
                    right++;
                    left--;
                }
                right = center;
                left = center - 1;
                 while (left >= 0 && right < s.length() &&s.charAt(left) == s.charAt(right)) {
                    String str = s.substring(left, right + 1);
                    if (result.length() <= str.length()) {
                        result = str;
                    }
                    right++;
                    left--;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring o = new LongestPalindromicSubstring();
        LongestPalindromicSubstring.Solution sol = o.new Solution();
        System.out.println(sol.longestPalindrome("aacabdkacaa"));
    }
}
