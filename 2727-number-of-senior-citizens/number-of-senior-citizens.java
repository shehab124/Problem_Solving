class Solution {
    public int countSeniors(String[] details) {
        int count = 0, age;
        for (int i = 0; i < details.length; i++) {
            age = (Character.getNumericValue(details[i].charAt(11)) * 10)
                    + Character.getNumericValue(details[i].charAt(12));
            if (age > 60)
                count++;
        }
        return count;
    }
}