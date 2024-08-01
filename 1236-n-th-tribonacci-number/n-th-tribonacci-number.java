class Solution {

    int[] mem;
    private int helper(int i)
    {
        if(mem[i] != -1)
            return mem[i];

        return mem[i] = helper(i - 1) + helper(i - 2) + helper( i - 3);
    }

    public int tribonacci(int n) {
        mem = new int[n+3];

        Arrays.fill(mem, -1);
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 1;
        return helper(n);
    }
}