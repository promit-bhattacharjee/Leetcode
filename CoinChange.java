package LeetCode;

import java.util.Arrays;

import Graph.BFS;

public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int dp[]= new int[amount+1];
            Arrays.fill(dp,amount+1);
            dp[0]=0;
            for(int i=1;i<dp.length;i++){
               for(int coin:coins){
                   if (i-coin>=0) {
                    dp[i]=Math.min(1+dp[i-coin], dp[i]);
                   } 
               }
            }
            return dp[amount]==amount+1?-1:dp[amount];

        }
    }

    public static void main(String[] args) {
        CoinChange out = new CoinChange();
        CoinChange.Solution sn = out.new Solution();
        int coins[] = {
              2
        };
        int amount = 11;
        System.out.println(sn.coinChange(coins, amount));
    }
}
