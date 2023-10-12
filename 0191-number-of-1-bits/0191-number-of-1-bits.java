public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int rem;
        for(int i = 0; i < 32; i++)
        {
            rem = n & 1;
            if(rem == 1)
                count++;
            n >>= 1;
        }
        return count;
    }
}