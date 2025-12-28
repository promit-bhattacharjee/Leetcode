package LeetCode;

public class ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            String str = s.toLowerCase();
            s = "";
            for (char c : str.toCharArray()) {
                if (Character.isLetter(c) || Character.isDigit(c)) {
                    if (Character.isUpperCase(c)) {
                        c = Character.toLowerCase(c);
                    }
                    s = s + c;
                }
            }
                int left = 0;
                int right = s.length() - 1;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        return false;
                    }
                    left++;
                    right--;
                }
            System.out.println(s);
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new ValidPalindrome().new Solution();
        String s = "A man, a plan, a canal: Panama";
        boolean result = sol.isPalindrome(s);
    }
}
