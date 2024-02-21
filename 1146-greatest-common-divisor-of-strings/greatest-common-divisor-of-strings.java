class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        if (!str1.concat(str2).equals(str2.concat(str1)))
            return "";
        StringBuilder result = new StringBuilder();

        if (!str1.concat(str2).equals(str2.concat(str1)))
            return "";
        int l1 = str1.length();
        int l2 = str2.length();
        int gcd = 1;

        for (int i = 1; i <= l1 && i <= l2; i++) {
            if (l1 % i == 0 && l2 % i == 0)
                gcd = i;
        }

        for (int i = 0; i < gcd; i++) {
            if (str1.charAt(i) == str2.charAt(i))
                result.append(str1.charAt(i));
            else
                return "";
        }

        return result.toString();
    }
}