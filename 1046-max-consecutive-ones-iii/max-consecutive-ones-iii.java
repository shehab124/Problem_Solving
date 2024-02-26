class Solution {
    public int longestOnes(int[] nums, int k) {
                int result = 0, zeroCount = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0)
                zeroCount++;

            while (zeroCount > k) {
                if (nums[i] == 0)
                    zeroCount--;
                i++;
            }
            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}