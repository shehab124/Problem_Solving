class Solution {
    List<List<Integer>> result;

    private void helper(int[] candidates,
                               int target,
                               List<Integer> current,
                               int index,
                               int sum)
    {
        if(sum == target)
        {
            List<Integer> copy = new ArrayList<>(current);
            result.add(copy);
            return;
        }

        if(sum > target)
            return;

        for(int i = index; i < candidates.length; i++)
        {
            sum += candidates[i];
            current.add(candidates[i]);

            helper(candidates, target, current, i, sum);

            sum -= candidates[i];
            current.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        helper(candidates, target, current, 0, 0);

        return result;
    }

}