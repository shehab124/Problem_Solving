class Solution
{
    public:
        bool isValid(string s)
        {
            if (s.size() % 2 == 1)
                return false;

            stack<char> stack;
            unordered_map<char, char> map;
            map['('] = ')';
            map['['] = ']';
            map['{'] = '}';

            char top;
            for (int i = 0; i < s.size(); i++)
            {
                if (map.find(s[i]) != map.end())	// if found
                {
                    stack.push(s[i]);
                }
                else
                {
                    if (stack.empty())
                        return false;
                    top = stack.top();
                    if (s[i] == map[top])
                        stack.pop();
                    else
                        return false;
                }
            }
            if (stack.empty())
                return true;
            else
                return false;
        }
};