class Solution {

    public int binarySearch(int[] nums, int target)
    {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r)
        {
            m = l + ( r - l)/2;
            if(nums[m] == target)
                return m;
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            int comp = target - numbers[i];
            int index = binarySearch(numbers, comp);
            if(index == i || index == -1)
                continue;
            else
            {
                index1 = i;
                index2 = index;
                break;
            }
        }
        int[] res = new int[2];
        if(index1 < index2)
        {
            res[0] = index1 + 1;
            res[1] = index2 + 1;
        }
        else{
            res[1] = index1 + 1;
            res[0] = index2 + 1;
        }
        return res;
    }
}