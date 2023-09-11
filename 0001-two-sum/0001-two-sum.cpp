class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) 
    {
        vector<int> indices;
        unordered_map<int, int> map;
        int res;


        for(int i = 0; i < nums.size() ; i++)
        {
            res = target - nums[i];

            if(map.find(res) != map.end())
            {
                return { i, map[res]};
            }
            map[nums[i]] = i;
        }
        return {};
    }
};