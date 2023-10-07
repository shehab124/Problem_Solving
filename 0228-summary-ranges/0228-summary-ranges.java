class Solution {
    public List<String> summaryRanges(int[] nums) 
    {
        List<String> result = new ArrayList<>();

        if(nums.length == 0)
            return result;

        int start = 0, end = 1;

        while(end < nums.length)
        {
            if(nums[end] == nums[end - 1] + 1)
            {
                end++;
            }
            else
            {
                if(nums[start] != nums[end-1])
                    result.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[end-1]));
                else
                    result.add(Integer.toString(nums[start]));
                start = end;
                end++;
            }
        }
        if(nums[end-1] == nums[start])
            result.add(Integer.toString(nums[start]));
        else
            result.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[end-1]));

        return result;    
    }
}