class Solution {

    private void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    public void rotate(int[] nums, int k)
    {
        k %= nums.length;

        // Reverse the last k elements in the array
        reverseArray(nums, nums.length - k, nums.length - 1);

        // Reverse the first n - k elements in the array
        reverseArray(nums, 0, nums.length - k - 1);

        // Reverse the entire array
        reverseArray(nums, 0, nums.length - 1);
    }
}