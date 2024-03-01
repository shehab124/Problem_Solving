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

    public static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            if (root.left == null && root.right == null)
                list.add(root.val);
            inorder(root.right, list);
        }
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        if (list1.size() != list2.size())
            return false;

        for (int i = 0; i < list1.size(); i++) {
            int x1 = list1.get(i);
            int x2 = list2.get(i);
            if (x1 != x2)
                return false;

        }
        return true;
    }
}