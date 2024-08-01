class Solution {
    static int[] mem;

    private static int helper(int i, int[] cost, int sum) {
        if (i >= cost.length)
            return sum;

        if (mem[i] != -1)
            return mem[i];

        return mem[i] = Math.min(helper(i + 1, cost, sum), helper(i + 2, cost, sum)) + cost[i];
    }

    public static int minCostClimbingStairs(int[] cost) {
        mem = new int[cost.length];
        Arrays.fill(mem, -1);
        return Math.min(helper(0, cost, 0), helper(1, cost, 0));
    }
}