class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int leftTotal = 1;
        int rightTotal = 1;
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length-1] = 1;

        for(int i = 1; i < nums.length; i++)
        {
            leftTotal *= nums[i-1];
            leftProduct[i] = leftTotal;
        }
        for(int i = nums.length - 2; i >= 0; i--) {
            rightTotal *= nums[i + 1];
            rightProduct[i] = rightTotal;
        }

        for(int i = 0; i < nums.length; i++)
            ans[i] = leftProduct[i] * rightProduct[i];

        return ans;
    }
}