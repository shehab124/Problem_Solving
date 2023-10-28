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
    boolean flag = false;
    public boolean sum(TreeNode root,int sum ,int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            sum += root.val;
            if (sum == targetSum)
                return true;
        }
        return sum(root.left, sum + root.val, targetSum) || sum(root.right, sum + root.val, targetSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return sum(root, sum, targetSum);
    }
}