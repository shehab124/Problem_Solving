class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        StringBuilder result = new StringBuilder();

        int c1 = 0, c2 = 0;
        int i = 0;

        while (c1 < l1 && c2 < l2) {
            if (i % 2 == 0) {
                result.append(word1.charAt(c1));
                c1++;
            } else {
                result.append(word2.charAt(c2));
                c2++;
            }
            i++;
        }

        if (c1 < l1) {
            result.append(word1.substring(c1));
        } else if (c2 < l2) {
            result.append(word2.substring(c2));
        }

        return result.toString();
    }
}