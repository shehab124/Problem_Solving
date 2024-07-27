class Solution {
    public static void combinations(int index , int k, int n, boolean[] visited, List<Integer> current, int currentSum, List<List<Integer>> result)
    {
        if(currentSum == n && current.size() == k)
        {
            List<Integer> arr = new ArrayList<>();
            for(int num : current)
            {
                arr.add(num);
            }
            result.add(arr);
            return;
        }
        if(current.size() == k)
            return;

        for(int i = index; i <= 9; i++)
        {
            if(!visited[i])
            {
                currentSum += i;
                visited[i] = true;
                current.add(i);

                combinations(i + 1, k, n, visited, current, currentSum, result);

                current.removeLast();
                visited[i] = false;
                currentSum -= i;
            }
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[10];
        List<Integer> current = new ArrayList<>();

        combinations(1, k, n, visited, current, 0, result);

        return result;
    }
}