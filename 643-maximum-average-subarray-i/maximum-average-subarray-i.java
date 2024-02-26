class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
            currentSum += nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            if (i + k - 1 < nums.length) {
                currentSum -= nums[i - 1];
                currentSum += nums[i + k - 1];
                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
        }
        return (maxSum * 1.0) / k;
    }
}