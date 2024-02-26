class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int maxSum = 0;

        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];

            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}