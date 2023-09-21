class Solution {

private:
    bool isAlphanumeric(char c) 
    {
        return std::isalnum(static_cast<unsigned char>(c)) != 0;
    }

public:
bool isPalindrome(string s)
{
    bool result = true;
    transform(s.begin(), s.end(), s.begin(), ::tolower);
    
    for(int i = 0, j = s.size()-1; i < s.size(); i++, j--)
    {
        if(!isAlphanumeric(s[i]))
        {
            j++;
            continue;
        }
        if(!isAlphanumeric(s[j]))
        {
            i--;
            continue;
        }

        if(s[i] != s[j])
            return false;
    }
    return true;

}

};