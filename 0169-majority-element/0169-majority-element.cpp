class Solution
{
    public:
        int majorityElement(vector<int> &nums)
        {
            unordered_map<int, int> map;
            int size = nums.size();
            int over2 = size / 2;
            for (int i = 0; i < size; i++)
            {
                map[nums[i]]++;
                if (map[nums[i]] > over2)
                    return nums[i];
            }
            return 0;
        }
};