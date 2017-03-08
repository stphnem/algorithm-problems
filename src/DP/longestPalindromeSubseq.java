/**
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/?tab=Description
 **/
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i=0; i < len; i++) {
        	dp[i][i] = 1;
        }

        for (int l=2; l <= len; l++) {
        	for (int i=0; i <= len - l; i++) {
        		int j = i + l - 1;
        		if (s.charAt(i) == s.charAt(j)) {
        			dp[i][j] = 2 + dp[i+1][j-1];
        		} else {
        			dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        		}
        	}
        }
        return dp[0][len - 1];
    }
}