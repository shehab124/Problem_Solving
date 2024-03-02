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

    public static int good(TreeNode root, int max) {
        if (root == null)
            return 0;

        int flag = 0;
        if (root.val >= max) {
            flag = 1;
            max = root.val;
        }

        return good(root.left, max) + flag + good(root.right, max);
    }

    public int goodNodes(TreeNode root) {
        return good(root, root.val);
    }
}