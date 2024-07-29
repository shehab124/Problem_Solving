class Solution {
        List<List<Integer>> result;

    public void helper(int[] nums, int index, List<Integer> current, List<Integer> visited)
    {
        if(current.size() == nums.length)
        {
            List<Integer> copy = new ArrayList<>(current);
            result.add(copy);
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(!visited.contains(nums[i]))
            {
                visited.add(nums[i]);
                current.add(nums[i]);

                helper(nums, i + 1, current, visited);

                visited.removeLast();
                current.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        helper(nums, 1, current, visited);

        return result;
    }
}