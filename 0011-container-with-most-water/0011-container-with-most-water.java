class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        int currentArea;
        while (start < end) {
            currentArea = Math.min(height[start], height[end]) * (end - start);
            if (currentArea > maxArea)
                maxArea = currentArea;
            if (height[start] <= height[end])
                start++;
            else
                end--;
        }
        return maxArea;
    }
}