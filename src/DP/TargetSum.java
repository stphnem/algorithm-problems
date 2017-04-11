/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/#/description
 *
 */
public class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum+= n;
        }

        if ((sum + S) % 2 != 0 || sum < S) {
            return 0;
        }

        return helper(nums, (S + sum) / 2);
    }

    public int helper(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int n : nums) {
            for (int i=target; i >= n; i--) {
                dp[i] += dp[i-n];
            }
        }

        return dp[target];
    }
}