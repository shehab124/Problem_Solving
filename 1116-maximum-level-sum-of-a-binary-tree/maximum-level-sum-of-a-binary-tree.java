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

    // returns height of binary tree
    public static int height(TreeNode root)
    {
        if(root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // calculate sum of each level using Preorder Traversal
    public void helper(TreeNode root, int[] sum, int level)
    {
        if(root == null)
            return;

        sum[level] = sum[level] + root.val;
        helper(root.left, sum, level+1);
        helper(root.right, sum, level+1);
    }


    public int maxLevelSum(TreeNode root) {
        int[] levels = new int[height(root) + 1];

        helper(root, levels, 1);

        int max = levels[1];
        int maxLevel = 1;
        
        for(int i = 1; i < levels.length; i++)
        {
            if(levels[i] > max)
            {
                maxLevel = i;
                max = levels[i];
            }
        }
        
        return maxLevel;
    }
}