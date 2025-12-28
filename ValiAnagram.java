package LeetCode;

import java.security.Key;
import java.util.HashMap;

public class ValiAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            HashMap<Character, Integer> sMap = new HashMap<>();
            HashMap<Character, Integer> tMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
            for (char c : t.toCharArray()) {
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            }

            // for (char c : tMap.keySet()) {
            //     if (sMap.containsKey(c)) {
            //         int i = sMap.get(c);
            //         int j = tMap.get(c);
            //         if (i == 1)
            //             sMap.remove(c);
            //         else
            //             sMap.put(c, i - 1);

            //         if (j == 1)
            //             tMap.remove(c);
            //         else
            //             tMap.put(c, j - 1);

            //     } else 
            //         return false;
                
            // }
            
            // if (sMap.isEmpty()&& tMap.isEmpty()) {
            //     return true;
            // }
            if (sMap.equals(tMap)) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new ValiAnagram().new Solution();
        String s = "anagram";
        String t = "nagaram";
        boolean result = sol.isAnagram(s, t);
        System.out.println("Is Anagram: " + result);
    }
}
