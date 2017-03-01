/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] arr = new int[m];
        for (int i=0; i < m; i++) {
            arr[i] = 1;
        }

        for (int i=1; i < n; i++) {
            for (int j=1; j < m; j++) {
                arr[j] = arr[j] + arr[j-1];
            }
        }

        return arr[m-1];
    }
}
