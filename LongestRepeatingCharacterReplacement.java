package LeetCode;

import java.util.HashMap;

import javax.print.DocFlavor.CHAR_ARRAY;

public class LongestRepeatingCharacterReplacement {
    class Solution {
        public int characterReplacement(String s, int k) {
            if (s.length() < 1) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            int left = 0;
            int right;
            int length=0;
            map.put(s.charAt(left), 1);
            int window = 1;
            right = left + 1;
            for (; right < s.length(); right++) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    int newValue = map.get(c) + 1;
                    map.put(c, newValue);
                    window = Math.max(window, newValue);
                } else {
                    map.put(c, 1);
                }
                String newStr;
                if (right != s.length() - 1)
                    newStr = s.substring(left, right + 1);
                else
                  newStr = s.substring(left, s.length());

                if (newStr.length() - window <= k) {
                    length=Math.max(length, newStr.length());
                }
                else{
                    char e = s.charAt(left);
                    map.put(e, map.get(e)-1);
                    left++;
                }

            }
            return length;
        }
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement out = new LongestRepeatingCharacterReplacement();
        LongestRepeatingCharacterReplacement.Solution sol = out.new Solution();
        String s = "AABABBA";
        int k = 1;

        int result = sol.characterReplacement(s, k);
        System.out.println("Result: " + result);
    }
}
