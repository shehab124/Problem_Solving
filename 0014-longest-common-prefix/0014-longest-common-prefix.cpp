class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) 
    {
        string pre = "";
        bool flag = true;
        bool flag2;
        for(int i = 0; i < strs[0].size() && flag; i++)
        {
            flag2 = true;
            for(int j=1;j<strs.size() && flag ;j++)
            {
                if(strs[0][i] != strs[j][i])
                {
                    flag2 = false;
                    flag = false;
                }
            }
            if(flag2)
            pre += strs[0][i];
        }
        return pre;
    }
};