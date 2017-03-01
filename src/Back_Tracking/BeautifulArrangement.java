/**
 * 526. Beautiful Arrangement
 * https://leetcode.com/problems/beautiful-arrangement/?tab=Description
 * 
 **/
 
public class Solution {
    int total = 0;
    
    public int countArrangement(int N) {
        helper(N, 1, new int[N+1]);
        return total;
    }
    
    public void helper(int N, int pos, int[] used) {
        if (pos > N) {
            total += 1;
            return;
        } 
        
        for (int i=1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
}
