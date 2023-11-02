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

    void helper(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        else {
            list.add(root.val);
            helper(root.left, list);
            helper(root.right, list);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        helper(root, arrayList);
        Collections.sort(arrayList);
        int min = arrayList.get(1) - arrayList.get(0);
        int newMin;
        for(int i = 1; i < arrayList.size() - 1; i++)
        {
            newMin = arrayList.get(i + 1) - arrayList.get(i);
            if(newMin < min)
                min = newMin;
        }
        return min;
        }
    }