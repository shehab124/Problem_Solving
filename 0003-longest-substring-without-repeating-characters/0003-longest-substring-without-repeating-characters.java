class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, currentLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        int start = 0, end = 0;

        while (end < s.length()) {

            if (map.containsKey(chars[end]) && map.get(chars[end]) >= start) {
                start = map.get(chars[end]) + 1;
            }

            currentLength = end - start + 1;
            maxLength = Math.max(currentLength, maxLength);

            map.put(chars[end], end);
            end++;
        }
        return maxLength;
    }
}