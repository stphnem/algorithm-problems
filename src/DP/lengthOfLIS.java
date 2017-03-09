/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/?tab=Description
 * 
 **/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i=0; i < nums.length; i++) {
        	dp[i] = 1;
        }

        for (int i=0; i < nums.length; i++) {
        	for (int j=0; j < i; j++) {
        		if (nums[j] < nums[i]) {
        			dp[i] = Math.max(dp[j] + 1, dp[i]);
        		}
        	}
        	if (max <= dp[i]) {
        	    max = dp[i];
        	}
        }

        return max;
    }
}