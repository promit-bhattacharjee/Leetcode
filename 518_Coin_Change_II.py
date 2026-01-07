# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         memo={}
#         def helper(amount,coins,index):
#             if (index,amount) in memo:
#                 return memo[(index,amount)]
#             if amount==0: 
#                 return 1
#             if amount<0 or index>=len(coins): 
#                 return 0
#             ways=0
#             ways=helper(amount-coins[index],coins,index)+helper(amount,coins,index+1)
#             memo[(index,amount)]=ways
#             return ways

#         return helper(amount,coins,0)
        
class Solution:
        def change(self, amount: int, coins: List[int]) -> int:
                dp = [0]*(amount+1)
                dp[0]=1

                for coin in coins:
                    for i in range(coin,amount+1):
                        dp[i]=dp[i]+dp[i-coin]
                
                return dp[amount]