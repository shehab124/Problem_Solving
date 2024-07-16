import java.util.PriorityQueue;

public class TotalCost {

    public static long totalCost(int[] costs, int k, int candidates) {
        int length = costs.length;
        int i = 0;
        int j = length - 1;
        long total = 0;

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        while (i < candidates)
            left.add(costs[i++]);

        while (j >= i && j >= length - candidates)
            right.add(costs[j--]);

        while (k > 0) {
            int minLeft = left.size() > 0 ? left.peek() : Integer.MAX_VALUE;
            int minRight = right.size() > 0 ? right.peek() : Integer.MAX_VALUE;

            if (minRight < minLeft) {
                total += minRight;
                right.poll();
                if (i <= j)
                    right.add(costs[j--]);
            } else {
                total += minLeft;
                left.poll();
                if (j >= i)
                    left.add(costs[i++]);
            }

            k--;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] costs = { 1, 2, 4, 1 };
        int k = 3;
        int candidates = 3;
        System.out.println(totalCost(costs, k, candidates));
    }
}
