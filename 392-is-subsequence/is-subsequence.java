class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length())
            return false;

        if (s.length() < 1)
            return true;

        int prevIndex = -1;
        for (int i = 0; i < t.length(); i++)
            if (t.charAt(i) == s.charAt(0)) {
                prevIndex = i;
                break;
            }

        if (prevIndex == -1)
            return false;

        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            boolean flag = false;
            for (int j = 0; j < t.length(); j++) {
                if (currentChar == t.charAt(j) && j > prevIndex) {
                    flag = true;
                    prevIndex = j;
                    break;
                }
            }
            if (flag == false)
                return false;
        }

        return true;
    }
}