/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public static int max(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        else if (b >= a && b >= c)
            return b;
        else
            return c;
    }

    public int helper(TreeNode root, boolean isLeft, int depth) {
        if (root == null)
            return depth;

        if (isLeft) {
            depth = max(
                    depth,
                    helper(root.right, false, depth + 1),
                    helper(root.left, true, 0));
        } else
            depth = max(depth,
                    helper(root.left, true, depth + 1),
                    helper(root.right, false, 0));

        return depth;
    }

    public int longestZigZag(TreeNode root) {
        return Math.max(helper(root.left, true, 0), helper(root.right, false, 0));
    }
}