class Solution {
    public int findKthLargest(int[] nums, int k) {
        int res = 0;

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : nums)
            queue.add(n);

        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }

        return res;
    }
}