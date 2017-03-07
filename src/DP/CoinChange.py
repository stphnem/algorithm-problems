"""
    322. Coin Change
    https://leetcode.com/problems/coin-change/?tab=Description
"""
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [sys.maxsize] * (amount + 1)
        dp[0] = 0
        chosen = [-1] * (amount + 1)

        for c in range(0, len(coins)):
            for i in range(coins[c], amount+1):
                if (dp[i - coins[c]] + 1 < dp[i]):
                    dp[i] = dp[i-coins[c]] + 1
                    chosen[i] = c

        return -1 if dp[amount] == sys.maxsize else dp[amount]