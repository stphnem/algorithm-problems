package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 449. Serialize and Deserialize BST
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String SEP = ",";
    private static final String NULL = "NULL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return NULL;

        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            sb.append(root.val).append(SEP);
            if (root.right != null) { stack.push(root.right); }
            if (root.left != null) { stack.push(root.left); }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> nodes = new LinkedList<>();
        for (String s : strs) {
            nodes.add(Integer.parseInt(s));
        }

        return helper(nodes);
    }

    public TreeNode helper(Queue<Integer> q) {
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> smallerQ = new LinkedList<>();

        while (!q.isEmpty() && q.peek() < root.val) {
            smallerQ.offer(q.poll());
        }

        root.left = helper(smallerQ);
        root.right = helper(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));