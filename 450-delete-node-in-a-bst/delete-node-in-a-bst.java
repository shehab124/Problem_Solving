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

     public static TreeNode InSucc(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            // case 1: delete leaf
            if (root.left == null && root.right == null) {
                root = null;
            }
            // case 2: root has 1 child
            else if (root.right == null) {
                TreeNode temp = root;
                root = root.left;
                temp = null;
            } else if (root.left == null) {
                TreeNode temp = root;
                root = root.right;
                temp = null;
            }
            // case 3: root has 2 children
            else {
                TreeNode temp = InSucc(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return root;
    }
}