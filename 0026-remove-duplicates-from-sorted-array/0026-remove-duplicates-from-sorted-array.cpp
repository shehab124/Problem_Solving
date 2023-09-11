class Solution {
public:
    int removeDuplicates(vector<int>& nums)
    {
        vector<int>::iterator new_end = nums.end();
        for(int i=0; i < nums.size(); i++)
        {
            new_end = remove(nums.begin() + i + 1, new_end, nums[i]);
        }
        return new_end - nums.begin() ;
    }
};