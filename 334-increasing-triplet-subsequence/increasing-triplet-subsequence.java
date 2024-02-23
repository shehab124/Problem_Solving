class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        int[] leftMin = new int[nums.length];
        leftMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftMin[i] < nums[i] && nums[i] < rightMax[i])
                return true;
        }
        return false;
    }
}