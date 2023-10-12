public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) 
    {
        int rem;
        int result = n % 2;
        n >>= 1;
        for(int i = 0; i < 31; i++)
        {
            rem = n%2;
            if(rem == 0)
                result <<= 1;
            else
            {
                result <<=1;
                result |= 1;
            }
            n >>=1;
        }
        
        return result;  
    }
}