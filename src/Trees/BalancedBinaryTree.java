package Trees;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        // Base cases
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        // Check the height of both trees
        int leftHeight = 0;
        int rightHeight = 0;
        if (root.left != null) {
            leftHeight = dfs(root.left);
        }
        if (root.right != null) {
            rightHeight = dfs(root.right);
        }

        // Compare heights
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        } else if (Math.abs(leftHeight-rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
