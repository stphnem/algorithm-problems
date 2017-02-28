/**
 * 515. Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/?tab=Description
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        if (root == null) return result;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for (int i=0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val > max) { max = node.val; }
                if (node.left != null) { queue.add(node.left); }
                if (node.right != null) { queue.add(node.right); }
            }
            result.add(max);
        }
        
        return result;
    }
}
