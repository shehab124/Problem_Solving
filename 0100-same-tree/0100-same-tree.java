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
    boolean ff = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null)
            return ff;
        if (p != null && q != null) {
                  if (p.val != q.val)
                        ff = false;
                  isSameTree(p.left, q.left);
                  isSameTree(p.right, q.right);
            }
            if ((p == null && q != null) || (p != null && q == null))
                  ff = false;
            return ff;
    }
}