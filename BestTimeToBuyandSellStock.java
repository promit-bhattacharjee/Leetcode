package LeetCode;

public class BestTimeToBuyandSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int l = prices.length;
            if (l == 0)
                return 0;
            int minPrice = prices[0];
            int maxProfit = 0;
            int i = 0;
            while (i < l) {
                int k = i + 1;
                
                    while (k < l && prices[k] > prices[i]) {
                        maxProfit = Math.max(maxProfit, prices[k] - prices[i]);
                        k++;
                    }
                
                i++;
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        Solution sol = new BestTimeToBuyandSellStock().new Solution();
        int[] prices = { 1,2,4 };
        int result = sol.maxProfit(prices);
        System.out.println("Maximum Profit: " + result);
    }
}
