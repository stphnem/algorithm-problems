/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/?tab=Description
 *
 **/
public class Solution {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(target, new ArrayList<>(), candidates, 0);
        return res;
    }

    public void backtrack(int rem, List<Integer> temp, int[] candidates, int start) {
        if (rem == 0) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i=start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) continue;
                if (rem - candidates[i] >= 0) {
                    temp.add(candidates[i]);
                    backtrack(rem-candidates[i], temp, candidates, i+1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
