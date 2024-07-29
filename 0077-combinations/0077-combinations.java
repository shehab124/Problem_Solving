class Solution {
    List<List<Integer>> result;

    private void comb(int n, int k, List<Integer> visited, List<Integer> current, int index)
    {
        if(current.size() == k) // base case
        {
            List<Integer> copy = new ArrayList<>();
            for (Integer num : current)
                copy.add(num);
            result.add(copy);
            return;
        }


        for(int i = index; i <= n; i++)
        {
            if(!visited.contains(i))
            {
                visited.add(i);
                current.add(i);

                comb(n, k, visited, current, i + 1);

                visited.removeLast();
                current.removeLast();
            }
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        comb(n,k, visited, current, 1);

        return result;
    }
}