class Solution {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD"))
            s = s.replaceFirst("AB|CD", "");
        return s.length();
    }
}