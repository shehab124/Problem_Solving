class Solution {
    static List<String> result;
    static HashMap<Character, String> map;

    private static void combinations(String digits, StringBuilder current, int indexDigit)
    {
        if(current.length() == digits.length())
        {
            if(!current.isEmpty())
                result.add(current.toString());
            return;
        }


        for(int i = 0; i < map.get(digits.charAt(indexDigit)).length(); i++)
        {
            current.append(map.get(digits.charAt(indexDigit)).charAt(i));
            combinations(digits, current, indexDigit + 1);
            current.deleteCharAt(indexDigit);
        }
    }
    
    public static List<String> letterCombinations(String digits) {
        
        result = new ArrayList<>();

        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder current = new StringBuilder();
        combinations(digits, current, 0);


        return result;
    }
}