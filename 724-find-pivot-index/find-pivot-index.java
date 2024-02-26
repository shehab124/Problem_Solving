class Solution {
    public int pivotIndex(int[] nums) {
        int sumL = 0;
        int sumR;

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++)
            totalSum += nums[i];

        sumR = totalSum;
        for (int i = 0; i < nums.length; i++) {
            sumR = totalSum - nums[i] - sumL;

            if (sumR == sumL)
                return i;

            sumL += nums[i];
        }
        return -1;
    }
}