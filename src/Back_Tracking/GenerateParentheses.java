/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/?tab=Description
 *
 **/
public class Solution {
    public List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return res;
    }

    public void backtrack(int n, int open, int close, StringBuilder sb) {
        if (sb.length() == n*2) {
            res.add(sb.toString());
        } else {
            if (open < n) {
                sb.append("(");
                backtrack(n, open + 1, close, sb);
                sb.deleteCharAt(sb.length()-1);
            }
            if (close < open) {
                sb.append(")");
                backtrack(n, open, close + 1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
