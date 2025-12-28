package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int memo[] = new int[n + 1];
            Arrays.fill(memo, n + 1);
            memo[0]=0;
            memo[1] = 1;
            for (int i = 2; i < memo.length; i++) {
                memo[i]=memo[i-1]+memo[i-2];
            }
            return memo[n];
        }
    }
    public static void main(String[] args) {
        ClimbingStairs out = new ClimbingStairs();
        ClimbingStairs.Solution sn = out.new Solution();
        int n=11;
        System.out.println(sn.climbStairs(n));
    }
}
