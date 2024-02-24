class Solution {
    public void moveZeroes(int[] nums) {
        int numsIndex = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {

                numsIndex = i;

                while (numsIndex < nums.length) {
                    if (nums[numsIndex] != 0) {
                        int temp = nums[numsIndex];
                        nums[numsIndex] = nums[i];
                        nums[i] = temp;
                        break;
                    } else
                        numsIndex++;
                }
            }
        }
    }
}