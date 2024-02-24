class Solution {
    public int compress(char[] chars) {
        if (chars.length <= 1)
            return chars.length;

        int read = 0;
        int write = 0;

        while (read < chars.length) {

            char currentChar = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write] = currentChar;
            write++;
            if (count > 1) {
                String number = Integer.toString(count);
                for (int i = 0; i < number.length(); i++) {
                    chars[write] = number.charAt(i);
                    write++;
                }
            }
        }

        return write;
    }
}