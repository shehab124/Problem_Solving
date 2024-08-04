class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for (int i = 0; i < nums.length; i++)
            if(nums[i] == 1)
                ones++;

        if(ones == 0 || ones == nums.length)
                return 0;

        // create new array
        int[] newNums = new int[nums.length * 2];
        for (int i = 0; i < newNums.length; i++)
            newNums[i] = nums[i % nums.length];

        int l = 0, r = 0;
        int maxWindowOnes = 0;
        int currentWindowOnes = 0;
        while (r < newNums.length)
        {
            if (newNums[r] == 1)
                currentWindowOnes++;

            if (r - l + 1 > ones)
            {
                currentWindowOnes -= newNums[l];
                l++;
            }

            maxWindowOnes = Math.max(currentWindowOnes, maxWindowOnes);

            r++;
        }

        return ones - maxWindowOnes;
    }
}