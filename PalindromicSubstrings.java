package LeetCode;
public class PalindromicSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            int length = s.length();
            int result = length;
            for (int center = 0; center < length; center++) {
                int left = center - 1;
                int right = center + 1;
                while (left >= 0 && right < length && s.charAt(left)==s.charAt(right)) {
                    result++;
                    right++;
                    left--;
                }
                 left = center;
                right = center+1;
                while (left >= 0 && right < length && s.charAt(left)==s.charAt(right)) {
                    result++;
                    right++;
                    left--;
                }
            }
            return result;
        }
    }

}
