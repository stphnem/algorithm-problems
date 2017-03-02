/**
 * 216. Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/?tab=Description
 * 
 **/
public class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }
    
    public void backtrack(int start, int rem, int maxSize, List<Integer> temp) {
        if (temp.size() == maxSize && rem == 0) {
            res.add(new ArrayList<>(temp));
        } else if (temp.size() == maxSize && rem > 0) {
            return;
        }
        else {
            for (int i=start; i <= 9; i++) {
                if (rem - i >= 0) {
                    temp.add(i);
                    backtrack(i+1, rem-i, maxSize, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}