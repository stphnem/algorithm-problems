/**
 * Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
    public int kthSmallest(TreeNode root, int k) {
    	if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }

        while (!stack.isEmpty() || k != 0) {
        	cur = stack.pop();
        	k--;
        	if (k == 0) return cur.val;
        	TreeNode right = cur.right;
        	while (right != null) {
        		stack.push(right);
        		right = right.left;
        	}
        }

        return -1;
    }
}