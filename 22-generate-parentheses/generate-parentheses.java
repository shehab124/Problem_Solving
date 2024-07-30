class Solution {
    List<String> result;

    private void helper(int open, int close, int n, StringBuilder current)
    {
        if(open == close && current.length() == n*2)
        {
            String copy = current.toString();
            result.add(copy);
            return;
        }

        if(open < n)
        {
            current.append("(");
            helper(++open, close, n, current);
            current.deleteCharAt(current.length() - 1);
            open -=1;
        }

        if(open > close && close < n)
        {
            current.append(")");
            helper(open, ++close, n, current);
            current.deleteCharAt(current.length() - 1);
            close -=1;
        }

    }


    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        helper(0, 0, n, current);

        return result;
    }
}