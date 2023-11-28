class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int maxLength = 1, length = 1;

        for (int object : set) {

            if (!set.contains(object - 1)) {
                int current = object;
                while (set.contains(current + length)) {
                    length++;
                }
                if (length > maxLength)
                    maxLength = length;
                length = 0;
            }

        }

        return maxLength;
    }
}