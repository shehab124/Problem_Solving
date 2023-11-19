class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int currentSum = 0;

        while (end < nums.length) {
            currentSum += nums[end];
            end++;

            while (start < end && currentSum >= target) {
                minLength = Math.min(minLength, end - start);
                currentSum -= nums[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}