package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            int n = strs.length;
            List<List<String>> ans = new ArrayList<>();
            String same[] = new String[n];
            for (int i = 0; i < n; i++) {
                char arr[] = strs[i].toCharArray();
                Arrays.sort(arr);
                same[i] = new String(arr);
            }
            boolean vis[] = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    int inc = i;
                    while (inc < n) {
                        if (!vis[inc] && same[i].equals(same[inc])) {
                            list.add(strs[inc]);
                            vis[inc] = true;
                        }
                        inc++;
                    }
                    ans.add(list);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        GroupAnagrams out = new GroupAnagrams();
        GroupAnagrams.Solution sn = out.new Solution();
        // String strs[] = {
        //         "eat","tea","tan","ate","nat","bat"
        // };
        String strs[] = {
                "cab", "tin", "pew", "duh", "ill",
                "may", "buy", "bar", "max", "doc"
        };
        List res = sn.groupAnagrams(strs);
        System.out.println(res);
    }
}
