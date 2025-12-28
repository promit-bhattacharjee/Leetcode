package LeetCode;

import java.util.Arrays;

import Graph.DFS;

public class DecodeWays {
    class Solution {
        int count;

        public int DFS(char[] str, int node, int memo[]) {
            int ways = 0;
            if (node >= str.length) {
                // count++;
                return 1;
            }
            if (memo[node] != -1) {
                return memo[node];
            }
            if (str[node] - '0' == 0) {
                return 0;
            }

            ways += DFS(str, node + 1, memo);
            if (node + 1 < str.length && (str[node] - '0') * 10 + str[node + 1] - '0' <= 26) {
                ways += DFS(str, node + 2, memo);
            }
            memo[node] = ways;
            return ways;

        }

        public int numDecodings(String s) {
            char[] str = s.toCharArray();
            this.count = 0;
            int memo[] = new int[str.length];
            Arrays.fill(memo, -1);
           return DFS(str, 0, memo);
        }
    }

    public static void main(String[] args) {
        Solution sol = new DecodeWays().new Solution();
        String s = "226";
        int result = sol.numDecodings(s);
        System.out.println(result);
    }
}
