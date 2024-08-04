class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();

        int l = 0, r = 0;
        int sum = 0;

        while (r < n)
        {
            sum += nums[r];
            arr.add(sum);

            r++;
            if (r == n)
            {
                l++;
                r = l;
                sum = 0;
            }
        }

        Collections.sort(arr);

        int result = 0;
        int MOD = 1000000007;
        for (int i = left - 1; i < right ; i++ )
            result = (result + arr.get(i)) % MOD;

        return result;
    }
}