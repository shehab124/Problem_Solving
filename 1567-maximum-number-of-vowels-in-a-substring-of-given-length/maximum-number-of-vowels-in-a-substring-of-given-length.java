class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                maxVowels++;
                currentVowels++;
            }
        }

        for (int i = 1; i < s.length(); i++) {
            if (i + k - 1 < s.length()) {
                if (isVowel(s.charAt(i - 1)))
                    currentVowels--;
                if (isVowel(s.charAt(i + k - 1)))
                    currentVowels++;
                if (currentVowels > maxVowels)
                    maxVowels = currentVowels;
            }
        }

        return maxVowels;
    }
}