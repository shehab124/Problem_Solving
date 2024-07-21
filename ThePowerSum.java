/**
 * ThePowerSum
 */
public class ThePowerSum {

    static int count = 0;

    // x -> total,  n -> power
    private static void sum(int x, int n, int i, int currSum)
    {
        if(currSum > x || Math.pow(i-1, n) > x)
            return;
        if(currSum == x)
        {
            count++;
            return;
        }
        
        sum(x, n, i + 1, currSum + (int)Math.pow(i, n));
        sum(x, n, i + 1, currSum);
    }


    public static int powerSum(int X, int N) {
        // Write your code here
            sum(X, N, 1, 0);
            return count;
        }


    public static void main(String[] args) {
        System.out.println( powerSum(10, 2));
    }
}