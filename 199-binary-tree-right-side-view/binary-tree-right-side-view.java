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
        public static int height(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void helper(TreeNode root, Integer level, Integer[] list) {
        if (root == null)
            return;

        list[level] = new Integer(root.val);
        helper(root.left, level + 1, list);
        helper(root.right, level + 1, list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        int height = height(root);
        Integer[] res = new Integer[height];

        helper(root, 0, res);

        return Arrays.asList(res);   
    }
}