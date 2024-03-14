class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++)
        {
            String binary = Integer.toBinaryString(i);
            int count = 0;
            for(int j = 0; j < binary.length(); j++)
            {
                if(binary.charAt(j) == '1')
                    count++;
            }
            res[i] = count;
        }
        
        return res;
    }
}