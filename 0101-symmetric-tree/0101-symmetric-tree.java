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
    void preorder(TreeNode node, ArrayList<Integer> arr) {
        if (node != null) {
            arr.add(node.val);
            preorder(node.left, arr);
            if (node.left == null && node.right != null)
                  arr.add(101);
            preorder(node.right, arr);
            if (node.left != null && node.right == null)
                  arr.add(101);
        }
    }

    void postorder(TreeNode node, ArrayList<Integer> arr) {
            if (node != null) {
                  postorder(node.left, arr);
                  if (node.left == null && node.right != null)
                        arr.add(101);
                  postorder(node.right, arr);
                  if (node.left != null && node.right == null)
                        arr.add(101);
                  arr.add(node.val);
            }
      }

    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        preorder(root.left, arr1);
        postorder(root.right, arr2);
        if (arr1.size() != arr2.size())
            return false;
        for (int i = 0, j = arr2.size() - 1; i < arr1.size() && j >= 0; i++, j--) {
            if (arr1.get(i) != arr2.get(j))
                return false;
        }

        return true;        
    }
}