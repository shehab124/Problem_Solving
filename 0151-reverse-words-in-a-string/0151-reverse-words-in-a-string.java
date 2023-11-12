class Solution {

    public String reverseWords(String s) {
        s = s.replaceAll("^\\s+", "");
        s = s.replaceAll("\\s+$", "");
        s = s.replaceAll("\\s{2,}", " ");

        String[] strings = s.split(" ");

        String result = "";

        for (int i = strings.length - 1; i >= 0; i--) {
            result += strings[i];
            if (i != 0) result += " ";
        }
        return result;
    }
}
