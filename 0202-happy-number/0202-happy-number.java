class Solution {

    int Sum(int n)
    {   
        int sum = 0;
        while(n != 0)
        {
            sum += Math.pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) 
    {
        Map<Integer, Integer> map = new HashMap<>();

        while(true)
        {
            if(map.containsKey(n))
                return false;

            int result = Sum(n);
            if(result == 1)
                return true;
            else
                map.put(n, Sum(n));
            n = result;
        }    
    }
}