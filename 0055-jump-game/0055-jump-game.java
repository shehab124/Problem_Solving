class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > reachable) return false; 
            else 
                reachable = Integer.max(reachable, i + nums[i]);
        }
        return true;
    }
}