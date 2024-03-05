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

    public static int res;

    public static void helper(TreeNode root, HashMap<Long, Integer> map, long prevSum, int target) {
        if (root == null)
            return;

        long currentSum = prevSum + root.val;

        long find = currentSum - target;
        if (currentSum == target)
            res++;

        if (map.containsKey(find))
            res += map.get(find);

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        helper(root.left, map, currentSum, target);
        helper(root.right, map, currentSum, target);

        map.put(currentSum, map.get(currentSum) - 1);
        
    }

    public int pathSum(TreeNode root, int targetSum) {
       res = 0;

        HashMap<Long, Integer> map = new HashMap<>();
        int sum = 0;

        helper(root, map, sum, targetSum);

        return res;
    }
}