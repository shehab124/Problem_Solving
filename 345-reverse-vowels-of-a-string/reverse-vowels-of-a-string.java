class Solution {
    public boolean isVowel(Character c) {
        char lowerCaseChar = Character.toLowerCase(c);
        return lowerCaseChar == 'a' || lowerCaseChar == 'e' || lowerCaseChar == 'i' || lowerCaseChar == 'o'
                || lowerCaseChar == 'u';
    }
    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (l < r) {
            if (isVowel(charArray[l]) && isVowel(charArray[r])) {
                char temp = charArray[l];
                charArray[l] = charArray[r];
                charArray[r] = temp;
                l++;
                r--;
            } else if (isVowel(charArray[l]))
                r--;
            else if (isVowel(charArray[r]))
                l++;
            else {
                l++;
                r--;
            }
        }
        return new String(charArray);
    }
}