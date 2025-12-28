package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class WordBreak {

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int length = s.length();
            boolean vis[] = new boolean[length + 1];
            vis[length]=true;
            for (int i = length - 1; i >= 0; i--) {
                for (String str : wordDict) {
                    if (i + str.length() <= length && !vis[i])  {
                        if (str.equals(s.substring(i, i+str.length())) && vis[i+str.length()]) {
                            vis[i]=true;
                        }
                    }
                }
            }
            return vis[0];
        }

    }

    // ✅ main method for testing
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        Solution sol = wb.new Solution();

        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");

        String s = "leetcodeleet";
        boolean result = sol.wordBreak(s, wordDict);
        System.out.println();
        System.out.println("Word break result: " + result);
    }
}
