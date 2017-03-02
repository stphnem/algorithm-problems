/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/?tab=Description
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), new boolean[nums.length], nums);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, boolean[] used, int[] nums) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i=0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                temp.add(nums[i]);
                used[i] = true;
                backtrack(ans, temp, used, nums);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
