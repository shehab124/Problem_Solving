class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 1;
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int length = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                length++;
            } else if (nums[i] == nums[i + 1])
                continue;
            else
                length = 1;
            if (length > maxLength)
                maxLength = length;
        }

        return maxLength;
    }
}