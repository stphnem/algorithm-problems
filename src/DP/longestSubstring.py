def printMatrix(matrix):
	for _ in matrix:
		print _

def longestSubstring(s1, s2):
	dp = [[0] * (len(s2) + 1) for _ in range(len(s1) + 1)]
	
	max = 0
	for i in range(1, len(dp)):
		for j in range(1, len(dp[0])):
			if (s1[i-1] == s2[j-1]):
				dp[i][j] = dp[i-1][j-1] + 1
				if (max < dp[i][j]):
					max = dp[i][j]

	return max

print(longestSubstring("abcdaf", "zbcdf"))