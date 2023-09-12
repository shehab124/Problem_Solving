class Solution
{
    public:
        int lengthOfLastWord(string s)
        {
            int lastIndex = s.find_last_not_of(" \t\n");
            int c = 0;
            for (int i = lastIndex; i >= 0; i--)
            {
                if (s[i] == ' ')
                    return c;
                c++;
            }
            return c;
        }
};